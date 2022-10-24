package com.example.copa2022.services;

import com.example.copa2022.dtos.LancaDataDoJogoDTO;
import com.example.copa2022.models.Chave;
import com.example.copa2022.models.Estadio;
import com.example.copa2022.models.Jogo;
import com.example.copa2022.repositories.ChaveRepository;
import com.example.copa2022.repositories.EstadioRepository;
import com.example.copa2022.repositories.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class JogoService {

    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    ChaveRepository chaveRepository;
    @Autowired
    EstadioRepository estadioRepository;

    public Jogo buscarJogoPeloId(Long id) {
        return jogoRepository.findById(id).orElseThrow(() -> new RuntimeException("Jogo não encontrado pelo ID."));
    }

    public List<Jogo> buscarPeloEstadio(Estadio estadio) {
        return jogoRepository.findAllByEstadio(estadio);
    }

    public List<Jogo> gerarJogos() {
        List<Estadio> estadios = estadioRepository.findAll();
        int contadorEstadios = 0;
        List<Chave> chaves = chaveRepository.findAll();
        List<Integer> sequenciaMandantes = Arrays.asList(0, 2, 3, 1, 2, 1);
        List<Integer> sequenciaVisitantes = Arrays.asList(1, 3, 0, 2, 0, 3);
        List<Jogo> jogos = new ArrayList<>();

        for (Chave c : chaves) {
            for (int j = 0; j < sequenciaMandantes.size(); j++) {
                Jogo jogo = new Jogo();
                jogo.setChave(c.getGrupo());
                jogo.setSelecaoMandante(c.getSelecoes().get(sequenciaMandantes.get(j)));
                jogo.setSelecaoVisitante(c.getSelecoes().get(sequenciaVisitantes.get(j)));
                jogo.setEstadio(estadios.get(contadorEstadios));
                contadorEstadios++;
                if (contadorEstadios >= estadios.size()) {
                    contadorEstadios = 0;
                }
                jogos.add(jogo);
            }
        }
        for (Jogo jogo : jogos) {
            jogoRepository.save(jogo);
        }
        return jogos;
    }

    public long lancarDataDoJogo(Long jogoId, LancaDataDoJogoDTO dataHoraJogo) {
        Jogo jogo = buscarJogoPeloId(jogoId);
        jogo.setDataHora(dataHoraJogo.getDataHoraJogo());
        List<Jogo> jogosNoEstadio = buscarPeloEstadio(jogo.getEstadio());
        jogosNoEstadio.remove(jogo);

        for (Jogo j: jogosNoEstadio) {
            if (j.getDataHora() == null) {
                jogosNoEstadio.remove(j);
            }
        }

        for (Jogo j : jogosNoEstadio) {
            if (jogo.getDataHora().until(j.getDataHora(), ChronoUnit.HOURS) < 48) {
                return jogo.getDataHora().until(j.getDataHora(), ChronoUnit.HOURS);
//                throw new RuntimeException("Deve haver um espaço de tempo maior que 2 dias entre cada jogo no estádio.");
            }
        }
        jogoRepository.save(jogo);
        return 0;
    }

}
