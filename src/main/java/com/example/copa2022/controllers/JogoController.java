package com.example.copa2022.controllers;

import com.example.copa2022.dtos.LancaDataDoJogoDTO;
import com.example.copa2022.models.Jogo;
import com.example.copa2022.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/jogos")
public class JogoController {

    @Autowired
    JogoService jogoService;

    @GetMapping
    public List<Jogo> jogos() {
        return jogoService.buscarTodos();
    }

    @PostMapping(path = "/gerar")
    public void gerarJogos() {
        jogoService.gerarJogos();
    }

    @PostMapping(path = "/{jogoId}")
    public void lancarDataDoJogo(@PathVariable Long jogoId, @RequestBody LancaDataDoJogoDTO lancaDataHoraDoJogoDTO) {
        jogoService.lancarDataDoJogo(jogoId, lancaDataHoraDoJogoDTO);
    }

}
