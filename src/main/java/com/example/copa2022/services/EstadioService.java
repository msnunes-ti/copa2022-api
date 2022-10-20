package com.example.copa2022.services;

import com.example.copa2022.dtos.AtualizaEstadioDTO;
import com.example.copa2022.dtos.CadastraEstadioDTO;
import com.example.copa2022.mappers.EstadioMapper;
import com.example.copa2022.models.Estadio;
import com.example.copa2022.repositories.EstadioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EstadioService {

    @Autowired
    EstadioRepository estadioRepository;

    public List<Estadio> findAll() {
        return estadioRepository.findAll();
    }

    public Estadio buscaPorId(Long id) {
        return estadioRepository.findById(id).orElseThrow(() -> new RuntimeException("Estádio não encontrado pelo ID"));
    }

    @Transactional
    public void cadastraEstadio(CadastraEstadioDTO cadastraEstadioDTO){
        Long estadios = estadioRepository.countByNomeEstadio(cadastraEstadioDTO.getNomeEstadio());
        if (estadios > 0) {
            throw new RuntimeException("Estádio já Cadastrado");
        }
        Estadio estadio = EstadioMapper.toCadastraEstadio(cadastraEstadioDTO);
        estadioRepository.save(estadio);
    }
    @Transactional
    public void atualizaEstadio(Long id, AtualizaEstadioDTO atualizaEstadioDTO) {
        Optional<Estadio> estadioSalvo = Optional.ofNullable(estadioRepository.findById(id).orElseThrow(() -> new RuntimeException("Estádio não encontrado pelo ID")));
        Estadio estadio = EstadioMapper.toAtualizaCadastro(atualizaEstadioDTO);
        estadio.setId(estadioSalvo.get().getId());
        estadioRepository.save(estadio);
    }

    public void deletaEstadio(Long id) {
        Estadio estadio = buscaPorId(id);
        estadioRepository.delete(estadio);
    }

}
