package com.example.copa2022.controllers;

import com.example.copa2022.models.Jogo;
import com.example.copa2022.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/jogos")
public class JogoController {

    @Autowired
    JogoService jogoService;

    @PostMapping
    public List<Jogo> gerarJogos() {
        return jogoService.gerarJogos();
    }

}
