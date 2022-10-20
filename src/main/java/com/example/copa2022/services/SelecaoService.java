package com.example.copa2022.services;

import com.example.copa2022.models.Selecao;
import com.example.copa2022.repositories.SelecaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SelecaoService {

    SelecaoRepository selecaoRepository;

    public Selecao buscaPorId(Long id) {
        return selecaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Seleção não encontrada pelo ID"));
    }


}
