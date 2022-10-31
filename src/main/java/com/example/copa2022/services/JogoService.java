package com.example.copa2022.services;

import com.example.copa2022.dtos.InformaResultadoDoJogoDTO;
import com.example.copa2022.dtos.JogoDTO;
import com.example.copa2022.dtos.LancaDataDoJogoDTO;
import com.example.copa2022.mappers.JogoMapper;
import com.example.copa2022.models.Chave;
import com.example.copa2022.models.Estadio;
import com.example.copa2022.models.Jogo;
import com.example.copa2022.repositories.ChaveRepository;
import com.example.copa2022.repositories.EstadioRepository;
import com.example.copa2022.repositories.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@AllArgsConstructor
public class JogoService {

    @Autowired
    JogoRepository jogoRepository;
    @Autowired
    ChaveRepository chaveRepository;
    @Autowired
    EstadioRepository estadioRepository;


    public List<JogoDTO> buscarTodos() {
        return JogoMapper.toJogoDTOList(jogoRepository.findAll());
    }

    public List<JogoDTO> buscarTodosPorNomeSelecao(String nomeSelecao) {
        List<Jogo> todosOsJogos = jogoRepository.findAll();
        List<Jogo> jogos = new ArrayList<>();
        for (Jogo j : todosOsJogos) {
            if (j.getSelecaoMandante().getNomeSelecao().equalsIgnoreCase(nomeSelecao)) {
                jogos.add(j);
            }
            if (j.getSelecaoVisitante().getNomeSelecao().equalsIgnoreCase(nomeSelecao)) {
                jogos.add(j);
            }
        }
        return JogoMapper.toJogoDTOList(jogos);
    }

    public JogoDTO buscarJogoDTOPeloId(Long id) {
        return JogoMapper.toJogoDTO(jogoRepository.findById(id).orElseThrow(() -> new RuntimeException("Jogo não encontrado pelo ID.")));
    }
    private Jogo buscaJogoPeloId(Long id) {
        return JogoMapper.toJogo(buscarJogoDTOPeloId(id));
    }

    public List<Jogo> buscarPeloEstadio(Estadio estadio) {
        return jogoRepository.findAllByEstadio(estadio);
    }

    @Transactional
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
    @Transactional
    public void lancarDataDoJogo(Long jogoId, LancaDataDoJogoDTO dataHoraJogo) {
        Jogo jogo = buscaJogoPeloId(jogoId);
        jogo.setDataHora(dataHoraJogo.getDataHoraJogo());
        List<Jogo> jogosNoEstadio = buscarPeloEstadio(jogo.getEstadio());
        jogosNoEstadio.remove(jogo);
        jogosNoEstadio.removeIf(j -> j.getDataHora() == null);

        for (Jogo j : jogosNoEstadio) {
            if (Math.abs(j.getDataHora().until(jogo.getDataHora(), ChronoUnit.HOURS)) < 48) {
                throw new RuntimeException("Deve haver um espaço de tempo maior que 2 dias entre cada jogo no estádio.");
            }
        }
        jogoRepository.save(jogo);
    }
    @Transactional
    public void InformaResultadoDoJogo (Long id, InformaResultadoDoJogoDTO informaResultadoDoJogoDTO) {
        Jogo jogo = buscaJogoPeloId(id);
        jogo.setGolsMandante(informaResultadoDoJogoDTO.getGolsMandante());
        jogo.setGolsVisitante(informaResultadoDoJogoDTO.getGolsVisitante());
        if (informaResultadoDoJogoDTO.getGolsMandante() == null || informaResultadoDoJogoDTO.getGolsVisitante() == null) {
            throw new RuntimeException("Não pode existir o campo: gols == null");
        }
        if (informaResultadoDoJogoDTO.getGolsMandante() < 0 || informaResultadoDoJogoDTO.getGolsVisitante() < 0) {
            throw new RuntimeException("Não pode existir número de gols menor que zero (0)");
        }
        if(informaResultadoDoJogoDTO.getGolsMandante() > informaResultadoDoJogoDTO.getGolsVisitante()) {
            jogo.getSelecaoMandante().setPontos(jogo.getSelecaoMandante().getPontos() + 3);
        }
        if(informaResultadoDoJogoDTO.getGolsMandante() < informaResultadoDoJogoDTO.getGolsVisitante()) {
            jogo.getSelecaoVisitante().setPontos(jogo.getSelecaoVisitante().getPontos() + 3);
        }
        if(Objects.equals(informaResultadoDoJogoDTO.getGolsMandante(), informaResultadoDoJogoDTO.getGolsVisitante())) {
            jogo.getSelecaoMandante().setPontos(jogo.getSelecaoMandante().getPontos() + 1);
            jogo.getSelecaoVisitante().setPontos(jogo.getSelecaoVisitante().getPontos() + 1);
        }
        jogoRepository.save(jogo);
    }
}
