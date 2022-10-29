package com.example.copa2022.mappers;

import com.example.copa2022.dtos.JogoDTO;
import com.example.copa2022.models.Jogo;

import java.util.ArrayList;
import java.util.List;

public class JogoMapper {

    public static Jogo toJogo(JogoDTO jogoDTO) {
        Jogo jogo = new Jogo();
        jogo.setId(jogoDTO.getId());
        jogo.setChave(jogoDTO.getChave());
        jogo.setSelecaoMandante(jogoDTO.getSelecaoMandante());
        jogo.setSelecaoVisitante(jogoDTO.getSelecaoVisitante());
        jogo.setEstadio(jogoDTO.getEstadio());
        jogo.setDataHora(jogoDTO.getDataHora());
        jogo.setGolsMandante(jogoDTO.getGolsMandante());
        jogo.setGolsVisitante(jogoDTO.getGolsVisitante());
        return jogo;
    }

    public static List<JogoDTO> toJogoDTOList(List<Jogo> jogos) {
        List<JogoDTO> jogoDTOList = new ArrayList<>();
        for (Jogo j : jogos) {
            JogoDTO jogoDTO = new JogoDTO();
            jogoDTO.setId(j.getId());
            jogoDTO.setChave(j.getChave());
            jogoDTO.setSelecaoMandante(j.getSelecaoMandante());
            jogoDTO.setSelecaoVisitante(j.getSelecaoVisitante());
            jogoDTO.setEstadio(j.getEstadio());
            jogoDTO.setDataHora(j.getDataHora());
            jogoDTO.setGolsMandante(j.getGolsMandante());
            jogoDTO.setGolsVisitante(j.getGolsVisitante());
            jogoDTOList.add(jogoDTO);
        }
        return  jogoDTOList;
    }
    public static JogoDTO toJogoDTO(Jogo jogo) {
        JogoDTO jogoDTO = new JogoDTO();
        jogoDTO.setId(jogo.getId());
        jogoDTO.setChave(jogo.getChave());
        jogoDTO.setSelecaoMandante(jogo.getSelecaoMandante());
        jogoDTO.setSelecaoVisitante(jogo.getSelecaoVisitante());
        jogoDTO.setEstadio(jogo.getEstadio());
        jogoDTO.setDataHora(jogo.getDataHora());
        jogoDTO.setGolsMandante(jogo.getGolsMandante());
        jogoDTO.setGolsVisitante(jogo.getGolsVisitante());
        return jogoDTO;
    }
}
