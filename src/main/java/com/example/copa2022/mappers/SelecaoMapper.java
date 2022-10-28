package com.example.copa2022.mappers;

import com.example.copa2022.dtos.AtualizaSelecaoDTO;
import com.example.copa2022.dtos.CadastraSelecaoDTO;
import com.example.copa2022.dtos.SelecaoDTO;
import com.example.copa2022.models.Selecao;

import java.util.ArrayList;
import java.util.List;

public class SelecaoMapper {

    public static Selecao toSelecao(SelecaoDTO selecaoDTO) {
        Selecao selecao = new Selecao();
        selecao.setId(selecaoDTO.getId());
        selecao.setNomeSelecao(selecaoDTO.getNomeSelecao());
        selecao.setPaisOrigem(selecaoDTO.getPaisOrigem());
        selecao.setCorDoUniforme(selecaoDTO.getCorDoUniforme());
        selecao.setRanking(selecaoDTO.getRanking());
        selecao.setPontos(selecaoDTO.getPontos());
        return selecao;
    }
    public static SelecaoDTO toSelecaoDTO(Selecao selecao) {
        SelecaoDTO selecaoDTO = new SelecaoDTO();
        selecaoDTO.setId(selecao.getId());
        selecaoDTO.setNomeSelecao(selecao.getNomeSelecao());
        selecaoDTO.setPaisOrigem(selecao.getPaisOrigem());
        selecaoDTO.setCorDoUniforme(selecao.getCorDoUniforme());
        selecaoDTO.setRanking(selecao.getRanking());
        selecaoDTO.setPontos(selecao.getPontos());
        return selecaoDTO;
    }

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

    public static List<SelecaoDTO> selecaoDTOList(List<Selecao> selecaoList) {
        List<SelecaoDTO> selecaoDTOList = new ArrayList<>();
        for (Selecao s : selecaoList) {
            SelecaoDTO selecaoDTO = new SelecaoDTO();
            selecaoDTO.setId(s.getId());
            selecaoDTO.setNomeSelecao(s.getNomeSelecao());
            selecaoDTO.setPaisOrigem(s.getPaisOrigem());
            selecaoDTO.setCorDoUniforme(s.getCorDoUniforme());
            selecaoDTO.setRanking(s.getRanking());
            selecaoDTO.setPontos(s.getPontos());
            selecaoDTOList.add(selecaoDTO);
        }
        return selecaoDTOList;
    }
}
