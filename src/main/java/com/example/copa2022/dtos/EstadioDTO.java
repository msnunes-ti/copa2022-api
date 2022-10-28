package com.example.copa2022.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadioDTO {

    private Long id;

    private String nomeEstadio;

    private String cidade;

    private long capacidade;
}
