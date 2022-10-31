package com.example.copa2022.dtos;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class LancaDataDoJogoDTO {

    @NotNull
    private LocalDateTime dataHoraJogo;
}
