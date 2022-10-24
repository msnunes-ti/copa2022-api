package com.example.copa2022.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "jogos")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String chave;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "Selecao_mandante_id")
    private Selecao selecaoMandante;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "selecao_visitante_id")
    private Selecao selecaoVisitante;

    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    private Integer golsMandante;

    private Integer golsVisitantes;
}
