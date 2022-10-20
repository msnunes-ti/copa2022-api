package com.example.copa2022.services;

import com.example.copa2022.dtos.AtualizaSelecaoDTO;
import com.example.copa2022.dtos.CadastraSelecaoDTO;
import com.example.copa2022.mappers.SelecaoMapper;
import com.example.copa2022.models.Selecao;
import com.example.copa2022.repositories.SelecaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SelecaoService {

    SelecaoRepository selecaoRepository;

    public Selecao buscarPeloRanking(Long posicaoNoRanking) {
        return selecaoRepository.findByRanking(posicaoNoRanking);
    }

    public Selecao buscaPorId(Long id) {
        return selecaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Seleção não encontrada pelo ID"));
    }

    public List<Selecao> buscaTodos() {
        return selecaoRepository.findAll();
    }
    @Transactional
    public void cadastraSelecao(CadastraSelecaoDTO cadastraSelecaoDTO){
        Selecao selecao = SelecaoMapper.toCadastraSelecao(cadastraSelecaoDTO);
        selecaoRepository.save(selecao);
    }
    @Transactional
    public void atualizaSelecao(Long id, AtualizaSelecaoDTO atualizaSelecaoDTO) {
        Selecao selecaoEncontrada = buscaPorId(id);
        Selecao selecao = SelecaoMapper.toAtualizaSelecao(atualizaSelecaoDTO);
        selecao.setId(selecaoEncontrada.getId());
        selecaoRepository.save(selecao);
    }

    public void deletaSelecao(Long id) {
        Selecao selecao = buscaPorId(id);
        selecaoRepository.delete(selecao);
    }
}
