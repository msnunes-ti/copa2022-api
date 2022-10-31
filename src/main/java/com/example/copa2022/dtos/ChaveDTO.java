package com.example.copa2022.dtos;

import com.example.copa2022.models.Selecao;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ChaveDTO {

    private long id;

    private String grupo;

    private List<Selecao> selecoes;

    private Integer quantidadeGrupos;
}
