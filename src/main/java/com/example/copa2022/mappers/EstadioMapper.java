package com.example.copa2022.mappers;

import com.example.copa2022.dtos.AtualizaEstadioDTO;
import com.example.copa2022.dtos.CadastraEstadioDTO;
import com.example.copa2022.models.Estadio;

public class EstadioMapper {

    public static Estadio toCadastraEstadio(CadastraEstadioDTO cadastraEstadioDTO) {
        Estadio estadio = new Estadio();
        estadio.setNomeEstadio(cadastraEstadioDTO.getNomeEstadio());
        estadio.setCidade(cadastraEstadioDTO.getCidade());
        estadio.setCapacidade(cadastraEstadioDTO.getCapacidade());
        return estadio;
    }

    public static Estadio toAtualizaCadastro(AtualizaEstadioDTO atualizaEstadioDTO) {
        Estadio estadio = new Estadio();
        estadio.setNomeEstadio(atualizaEstadioDTO.getNomeEstadio());
        estadio.setCidade(atualizaEstadioDTO.getCidade());
        estadio.setCapacidade(atualizaEstadioDTO.getCapacidade());
        return estadio;
    }
}
