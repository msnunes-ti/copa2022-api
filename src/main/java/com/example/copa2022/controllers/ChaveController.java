package com.example.copa2022.controllers;

import com.example.copa2022.models.Selecao;
import com.example.copa2022.services.ChaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/chaves")
public class ChaveController {

    @Autowired
    ChaveService chaveService;

    @GetMapping
    public List<Selecao> selecoesOrdenadas() {
        return chaveService.gerarListaDeChaves();
    }
}
