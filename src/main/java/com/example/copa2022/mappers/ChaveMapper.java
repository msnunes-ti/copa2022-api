package com.example.copa2022.mappers;

import com.example.copa2022.dtos.ChaveDTO;
import com.example.copa2022.models.Chave;

import java.util.ArrayList;
import java.util.List;

public class ChaveMapper {

      public static List<ChaveDTO> toChaveDTOList(List<Chave> chaves) {
          List<ChaveDTO> chaveDTOList = new ArrayList<>();
          for (Chave c : chaves) {
              ChaveDTO chaveDTO = new ChaveDTO();
              chaveDTO.setId(c.getId());
              chaveDTO.setGrupo(c.getGrupo());
              chaveDTO.setSelecoes(c.getSelecoes());
              chaveDTO.setQuantidadeGrupos(c.getQuantidadeGrupos());
              chaveDTOList.add(chaveDTO);
          }
          return chaveDTOList;
      }
}
