package com.example.copa2022.repositories;

import com.example.copa2022.models.Jogo;
import com.example.copa2022.models.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelecaoRepository extends JpaRepository<Selecao, Long> {

    Selecao findByRanking (Long posicaoNoRanking);

    List<Selecao> findAllByOrderByRankingAsc();

    List<Selecao> findAllByNomeSelecao(String nomeSelecao);
}
