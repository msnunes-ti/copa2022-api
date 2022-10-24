package com.example.copa2022.services;

import com.example.copa2022.models.Chave;
import com.example.copa2022.models.Estadio;
import com.example.copa2022.models.Jogo;
import com.example.copa2022.repositories.ChaveRepository;
import com.example.copa2022.repositories.EstadioRepository;
import com.example.copa2022.repositories.JogoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//        for (Jogo jogo : jogos) {
//            jogoRepository.save(jogo);
//        }
        return jogos;
    }


}
