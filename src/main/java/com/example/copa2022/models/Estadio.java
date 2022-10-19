package com.example.copa2022.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "estadio")
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome_estadio")
    private String nomeEstadio;

    @NotNull
    @Column(name = "cidade", unique = true)
    private String cidade;

    @NotNull
    @Column(name = "capacidade")
    private long capacidade;

}
