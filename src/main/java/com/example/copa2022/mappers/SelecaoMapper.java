package com.example.copa2022.mappers;

import com.example.copa2022.dtos.AtualizaSelecaoDTO;
import com.example.copa2022.dtos.CadastraSelecaoDTO;
import com.example.copa2022.models.Selecao;

public class SelecaoMapper {

    public static Selecao toCadastraSelecao(CadastraSelecaoDTO cadastraSelecaoDTO) {
        Selecao selecao = new Selecao();
        selecao.setNomeSelecao(cadastraSelecaoDTO.getNomeSelecao());
        selecao.setPaisOrigem(cadastraSelecaoDTO.getPaisOrigem());
        selecao.setCorDoUniforme(cadastraSelecaoDTO.getCorDoUniforme());
        selecao.setRanking(cadastraSelecaoDTO.getRanking());
        selecao.setPontos(0);
        return selecao;
    }

    public static Selecao toAtualizaSelecao(AtualizaSelecaoDTO atualizaSelecaoDTO) {
        Selecao selecao = new Selecao();
        selecao.setNomeSelecao(atualizaSelecaoDTO.getNomeSelecao());
        selecao.setPaisOrigem(atualizaSelecaoDTO.getPaisOrigem());
        selecao.setCorDoUniforme(atualizaSelecaoDTO.getCorDoUniforme());
        selecao.setRanking(atualizaSelecaoDTO.getRanking());
        selecao.setPontos(atualizaSelecaoDTO.getPontos());
        return selecao;
    }
}
