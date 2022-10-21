package com.example.copa2022.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Chave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String letraDoGrupo;

    @NotNull
    private Selecao selecao1;

    @NotNull
    private Selecao selecao2;

    @NotNull
    private Selecao selecao3;

    @NotNull
    private Selecao selecao4;

    @NotNull
    private Integer quantidadeGrupos;
}
