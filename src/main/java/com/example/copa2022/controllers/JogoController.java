package com.example.copa2022.controllers;

import com.example.copa2022.dtos.LancaDataDoJogoDTO;
import com.example.copa2022.services.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/jogos")
public class JogoController {

    @Autowired
    JogoService jogoService;

    @PostMapping(path = "/gerar")
    public void gerarJogos() {
        jogoService.gerarJogos();
    }

    @PostMapping(path = "/{jogoId}")
    public long lancarDataDoJogo(@PathVariable Long jogoId, @RequestBody LancaDataDoJogoDTO lancaDataHoraDoJogoDTO) {
        return jogoService.lancarDataDoJogo(jogoId, lancaDataHoraDoJogoDTO);
    }

}
