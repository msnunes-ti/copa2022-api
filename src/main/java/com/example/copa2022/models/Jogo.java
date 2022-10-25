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

    @ManyToOne
    @JoinColumn(name = "Selecao_mandante_id")
    private Selecao selecaoMandante;

    @ManyToOne
    @JoinColumn(name = "selecao_visitante_id")
    private Selecao selecaoVisitante;

    @ManyToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    private LocalDateTime dataHora;

    private Integer golsMandante;

    private Integer golsVisitante;
}
