package com.example.copa2022.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    private List<Selecao> selecoes;


    @NotNull
    private Integer quantidadeGrupos;
}
