package com.example.copa2022.mappers;

import com.example.copa2022.dtos.AtualizaEstadioDTO;
import com.example.copa2022.dtos.CadastraEstadioDTO;
import com.example.copa2022.dtos.EstadioDTO;
import com.example.copa2022.models.Estadio;

import java.util.ArrayList;
import java.util.List;

public class EstadioMapper {

    public static Estadio toEstadio(EstadioDTO estadioDTO){
        Estadio estadio = new Estadio();
        estadio.setId(estadioDTO.getId());
        estadio.setNomeEstadio(estadioDTO.getNomeEstadio());
        estadio.setCidade(estadioDTO.getCidade());
        estadio.setCapacidade(estadioDTO.getCapacidade());
        return estadio;
    }
    public static EstadioDTO toEstadioDTO(Estadio estadio) {
        EstadioDTO estadioDTO = new EstadioDTO();
        estadioDTO.setId(estadio.getId());
        estadioDTO.setNomeEstadio(estadio.getNomeEstadio());
        estadioDTO.setCidade(estadio.getCidade());
        estadioDTO.setCapacidade(estadio.getCapacidade());
        return estadioDTO;
    }
    public static List<EstadioDTO> ToEstadioDtoList(List<Estadio> estadios){
        List<EstadioDTO> estadiosDTO = new ArrayList<>();
        for (Estadio e : estadios) {
            EstadioDTO estadioDTO = new EstadioDTO();
            estadioDTO.setId(e.getId());
            estadioDTO.setNomeEstadio(e.getNomeEstadio());
            estadioDTO.setCidade(e.getCidade());
            estadioDTO.setCapacidade(e.getCapacidade());
            estadiosDTO.add(estadioDTO);
        }
        return estadiosDTO;
    }

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
