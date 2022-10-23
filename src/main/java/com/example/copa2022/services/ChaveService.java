package com.example.copa2022.services;

import com.example.copa2022.models.Chave;
import com.example.copa2022.models.Selecao;
import com.example.copa2022.repositories.ChaveRepository;
import com.example.copa2022.repositories.SelecaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ChaveService {

    @Autowired
    ChaveRepository chaveRepository;
    @Autowired
    SelecaoRepository selecaoRepository;

    public List<Chave> gerarListaDeChaves() {
        List<Selecao> selecoesOrdenadas = selecaoRepository.findAllByOrderByRankingAsc();
        if((selecoesOrdenadas.size() % 4 != 0)) {
            throw new RuntimeException("Não foi possível gerar as chaves com 4 seleções.");
        }
        int quantidadeChaves = selecoesOrdenadas.size() / 4;
        List<String> letras = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        List<Chave> chaves = new ArrayList<>();

        for(int i = 0; i < quantidadeChaves; i++) {
            Chave chave = new Chave();
            chave.setGrupo(letras.get(i));
            chave.setQuantidadeGrupos(quantidadeChaves);
            List<Selecao> selecoes = new ArrayList<>();
            selecoes.add(selecoesOrdenadas.get(i));
            chave.setSelecoes(selecoes);
            chaves.add(chave);
        }
        if (quantidadeChaves > 0) {
            selecoesOrdenadas.subList(0, quantidadeChaves).clear();
        }
        Collections.shuffle(selecoesOrdenadas);
        for(int i = 0, j = 0; i < quantidadeChaves; i++) {
            List<Selecao> selecoes = chaves.get(i).getSelecoes();
            selecoes.add(selecoesOrdenadas.get(j));
            j++;
            selecoes.add(selecoesOrdenadas.get(j));
            j++;
            selecoes.add(selecoesOrdenadas.get(j));
            j++;
            chaves.get(i).setSelecoes(selecoes);
        }
//        for (int i = 0; i < chaves.size(); i++) {
//            chaveRepository.save(chaves.get(i));
//        }
        return chaves;
    }

    public Chave buscarChave(Long id) {
        return chaveRepository.findById(id).orElseThrow(() -> new RuntimeException("Chave não encontrada pelo ID."));
    }

    public List<Chave> buscarTodasChaves() {
        return chaveRepository.findAll();
    }

    public void deletarChave(Long id) {
        Chave chave = buscarChave(id);
        chaveRepository.delete(chave);
    }
}

