package com.example.copa2022.repositories;

import com.example.copa2022.models.Selecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelecaoRepository extends JpaRepository<Selecao, Long> {

}
