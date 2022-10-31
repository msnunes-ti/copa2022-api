package com.example.copa2022.controllers;

import com.example.copa2022.dtos.ChaveDTO;
import com.example.copa2022.models.Chave;
import com.example.copa2022.services.ChaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/chaves")
public class ChaveController {

    @Autowired
    ChaveService chaveService;

    @GetMapping
    public List<ChaveDTO> buscarTodasChaves() {
        return chaveService.buscarTodasChaves();
    }

    @GetMapping(path = "/{id}")
    public Chave buscarChave(@PathVariable Long id) {
        return chaveService.buscarChave(id);
    }

    @PostMapping
    public List<Chave> gerarListaDeChaves() {
        return chaveService.gerarListaDeChaves();
    }

    @DeleteMapping(path = "/{id}")
    public void deletarChave(@PathVariable Long id) {
        chaveService.deletarChave(id);
    }
}
