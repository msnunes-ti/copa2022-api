package com.example.copa2022.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InformaResultadoDoJogoDTO {

    @NotNull
    private Integer golsMandante;

    @NotNull
    private Integer golsVisitantes;
}
