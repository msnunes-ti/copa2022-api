package com.example.copa2022.services;

import com.example.copa2022.models.Chave;
import com.example.copa2022.repositories.ChaveRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ChaveService {

    @Autowired
    ChaveRepository chaveRepository;
    @Autowired
    SelecaoService selecaoService;

    public List<Chave> gerarListaDeChaves() {
        List<Chave> chavesGeradas = new ArrayList<>();
        





        return chavesGeradas;
    }
}
