package com.example.copa2022.services;

import com.example.copa2022.dtos.CadastraEstadioDTO;
import com.example.copa2022.mappers.EstadioMapper;
import com.example.copa2022.models.Estadio;
import com.example.copa2022.repositories.EstadioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadioService {

    @Autowired
    EstadioRepository estadioRepository;

    public List<Estadio> findAll() {
        return estadioRepository.findAll();
    }

    @Transactional
    public void cadastraEstadio(CadastraEstadioDTO cadastraEstadioDTO){
        Long estadios = estadioRepository.countByNomeEstadio(cadastraEstadioDTO.getNomeEstadio());
        if (estadios > 0) {
            throw new RuntimeException("Estádio já Cadastrado");
        }
        Estadio estadio = EstadioMapper.toEstadio(cadastraEstadioDTO);
        estadioRepository.save(estadio);
    }

    public void atualizaEstadio()
}
