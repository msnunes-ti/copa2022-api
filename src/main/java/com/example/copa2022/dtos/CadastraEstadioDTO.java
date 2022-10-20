package com.example.copa2022.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastraEstadioDTO {

    @NotNull
    private String nomeEstadio;

    @NotNull
    private String cidade;

    @NotNull
    private long capacidade;
}
