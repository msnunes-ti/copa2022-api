package com.example.copa2022.services;

import com.example.copa2022.dtos.CadastraSelecaoDTO;
import com.example.copa2022.mappers.SelecaoMapper;
import com.example.copa2022.models.Selecao;
import com.example.copa2022.repositories.SelecaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SelecaoService {

    SelecaoRepository selecaoRepository;

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
}
