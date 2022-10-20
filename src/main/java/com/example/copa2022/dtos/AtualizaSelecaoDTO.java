package com.example.copa2022.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizaSelecaoDTO {

    @NotNull
    private String nomeSelecao;

    @NotNull
    private String paisOrigem;

    @NotNull
    private String corDoUniforme;

    @NotNull
    private Long ranking;
}
