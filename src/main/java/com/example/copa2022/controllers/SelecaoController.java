package com.example.copa2022.controllers;

import com.example.copa2022.dtos.AtualizaSelecaoDTO;
import com.example.copa2022.dtos.CadastraSelecaoDTO;
import com.example.copa2022.dtos.SelecaoDTO;
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
    public SelecaoDTO buscaPeloRanking(@PathVariable Long posicaoNoRanking){
        return selecaoService.buscarPeloRanking(posicaoNoRanking);
    }

    @GetMapping(path = "/{id}")
    public SelecaoDTO buscarPorID(@PathVariable Long id) {
        return selecaoService.buscaPorId(id);
    }

    @GetMapping
    public List<SelecaoDTO> buscarTodos() {
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
