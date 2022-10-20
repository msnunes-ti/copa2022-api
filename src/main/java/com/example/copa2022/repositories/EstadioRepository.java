package com.example.copa2022.repositories;

import com.example.copa2022.models.Estadio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadioRepository extends JpaRepository<Estadio, Long> {

    Long countByNomeEstadio(String nome);



}
