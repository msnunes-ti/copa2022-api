package com.example.copa2022.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelecaoDTO {

    private Long id;

    private String nomeSelecao;

    private String paisOrigem;

    private String corDoUniforme;

    private Long ranking;

    private Integer pontos;
}
