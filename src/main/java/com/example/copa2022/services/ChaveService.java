package com.example.copa2022.services;

import com.example.copa2022.models.Chave;
import com.example.copa2022.models.Selecao;
import com.example.copa2022.repositories.ChaveRepository;
import com.example.copa2022.repositories.SelecaoRepository;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
@AllArgsConstructor
public class ChaveService {

    @Autowired
    ChaveRepository chaveRepository;
    @Autowired
    SelecaoRepository selecaoRepository;

    public List<Selecao> gerarListaDeChaves() {
        List<Selecao> selecoesOrdenadas = selecaoRepository.findAllByOrderByRankingAsc();
        if((selecoesOrdenadas.size() % 4 != 0)) {
            throw new RuntimeException("Não foi possível gerar as chaves com 4 seleções.");
        }
        int quantidadeChaves = selecoesOrdenadas.size();
        List<String> letras = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q");
        for(int i = 0; i < quantidadeChaves; i++) {
            Chave chave = new Chave();
            chave.setGrupo(letras.get(i));
            chave.setQuantidadeGrupos(selecoesOrdenadas.size() / 4);

        }


        return selecoesOrdenadas;
    }
}

