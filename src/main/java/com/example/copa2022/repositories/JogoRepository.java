package com.example.copa2022.repositories;

import com.example.copa2022.models.Estadio;
import com.example.copa2022.models.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findAllByEstadio(Estadio estadio);

    List<Jogo> findAllByNomeSelecao(String nomeSelecao);
}
