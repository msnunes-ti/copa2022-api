package com.example.copa2022.controllers;

import com.example.copa2022.dtos.AtualizaSelecaoDTO;
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

    @GetMapping(path = "/ranking/{posicaoNoRanking}")
    public Selecao buscaPeloRanking(@PathVariable Long posicaoNoRanking){
        return selecaoService.buscarPeloRanking(posicaoNoRanking);
    }

    @GetMapping(path = "/{id}")
    public Selecao buscarPorID(@PathVariable Long id) {
        return selecaoService.buscaPorId(id);
    }
    @GetMapping
    public List<Selecao> buscarTodos() {
        return selecaoService.buscaTodos();
    }
    @PostMapping
    public @ResponseBody void cadastraSelecao(@RequestBody CadastraSelecaoDTO cadastraSelecaoDTO) {
        selecaoService.cadastraSelecao(cadastraSelecaoDTO);
    }
    @PutMapping(path = "/{id}")
    public @ResponseBody void atualizaSelecao(@PathVariable Long id, @RequestBody AtualizaSelecaoDTO atualizaSelecaoDTO) {
        selecaoService.atualizaSelecao(id, atualizaSelecaoDTO);
    }

    @DeleteMapping(path = "/{id}")
    public void deletaSelecao(@PathVariable Long id) {
        selecaoService.deletaSelecao(id);
    }
}
