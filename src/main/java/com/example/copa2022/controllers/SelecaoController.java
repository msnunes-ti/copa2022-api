package com.example.copa2022.controllers;

import com.example.copa2022.models.Selecao;
import com.example.copa2022.services.SelecaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/selecoes")
@AllArgsConstructor
public class SelecaoController {

    SelecaoService selecaoService;

    

    @GetMapping(path = "/{id}")
    public Selecao buscarPorID(long id) {
        return selecaoService.buscaPorId(id);
    }
}
