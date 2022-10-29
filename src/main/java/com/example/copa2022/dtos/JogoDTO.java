package com.example.copa2022.dtos;

import com.example.copa2022.models.Estadio;
import com.example.copa2022.models.Selecao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class JogoDTO {

    private Long id;

    private String chave;

    private Selecao selecaoMandante;

    private Selecao selecaoVisitante;

    private Estadio estadio;

    private LocalDateTime dataHora;

    private Integer golsMandante;

    private Integer golsVisitante;
}
