package com.example.copa2022.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;

@Entity
@Getter
@Setter
@Table(name = "selecao")
public class Selecao implements Comparable<Selecao> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nome_selecao", unique = true)
    private String nomeSelecao;

    @NotNull
    @Column (name = "pais_origem")
    private String paisOrigem;

    @NotNull
    @Column(name = "cor_uniforme")
    private String corDoUniforme;

    @NotNull
    @Column(unique = true)
    private Long ranking;

    @Column(name = "pontos")
    private Integer pontos;

    @Override
    public int compareTo(Selecao outraSelecao) {
        if (this.pontos > outraSelecao.getPontos()) {
            return -1;
        } if (this.pontos < outraSelecao.getPontos()) {
            return 1;
        }
        return 0;
    }
}


