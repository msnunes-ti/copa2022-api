package com.example.copa2022.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "chaves")
public class Chave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String grupo;

    @NotNull
    @OneToOne
    private Selecao selecaoUm;

    @NotNull
    @OneToOne
    private Selecao selecaoDois;

    @NotNull
    @OneToOne
    private Selecao selecaoTres;

    @NotNull
    @OneToOne
    private Selecao selecaoQuatro;

    @NotNull
    private Integer quantidadeGrupos;
}
