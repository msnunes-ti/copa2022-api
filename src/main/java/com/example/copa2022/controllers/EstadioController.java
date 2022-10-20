package com.example.copa2022.controllers;

import com.example.copa2022.dtos.AtualizaEstadioDTO;
import com.example.copa2022.dtos.CadastraEstadioDTO;
import com.example.copa2022.models.Estadio;
import com.example.copa2022.services.EstadioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/estadios")
public class EstadioController {

    @Autowired
    EstadioService estadioService;

    @GetMapping
    public List<Estadio> buscaEstadios() {
        return estadioService.findAll();
    }
    @GetMapping(path = "/{id}")
    public Estadio buscaPorId(@PathVariable Long id){
        return estadioService.buscaPorId(id);
    }

    @PostMapping
    public @ResponseBody void cadastraEstadio(@RequestBody CadastraEstadioDTO cadastraEstadioDTO) {
        estadioService.cadastraEstadio(cadastraEstadioDTO);
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody void atualizaEstadio(@PathVariable Long id, @RequestBody AtualizaEstadioDTO atualizaEstadioDTO) {
        estadioService.atualizaEstadio(id, atualizaEstadioDTO);
    }
    @DeleteMapping(path = "/{id}")
    public void deletaPorId(@PathVariable Long id) {
        estadioService.deletaEstadio(id);
    }
}
