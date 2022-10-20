package com.example.copa2022.controllers;

import com.example.copa2022.dtos.CadastraSelecaoDTO;
import com.example.copa2022.models.Selecao;
import com.example.copa2022.services.SelecaoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/selecoes")
@AllArgsConstructor
public class SelecaoController {

    SelecaoService selecaoService;

    @GetMapping(path = "/{id}")
    public Selecao buscarPorID(@PathVariable Long id) {
        return selecaoService.buscaPorId(id);
    }
    @GetMapping
    public List<Selecao> buscarTodos() {
        return selecaoService.buscaTodos();
    }
    @PostMapping
    public void cadastraSelecao(CadastraSelecaoDTO cadastraSelecaoDTO) {
        selecaoService.cadastraSelecao(cadastraSelecaoDTO);
    }
}
