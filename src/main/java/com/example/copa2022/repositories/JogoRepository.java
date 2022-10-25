package com.example.copa2022.repositories;

import com.example.copa2022.models.Estadio;
import com.example.copa2022.models.Jogo;
import com.example.copa2022.models.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.ListJoin;
import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    List<Jogo> findAllByEstadio(Estadio estadio);

    List<Jogo> findAllBySelecao(Selecao selecao);
}
