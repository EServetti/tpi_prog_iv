package com.correa_servetti.tpi_prode.mappers;

import com.correa_servetti.tpi_prode.dto.GrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.GrupoResponseDTO;
import com.correa_servetti.tpi_prode.models.Grupo;

public class GrupoMapper {
    public static Grupo toEntity(GrupoRequestDTO dto){
        Grupo grupo = new Grupo();

        grupo.setNombre(dto.getNombre());
        grupo.setCodigoInvitacion(dto.getCodigoInvitacion());

        return grupo;
    }

    public static GrupoResponseDTO toResponseDTO(Grupo grupo){
        return new GrupoResponseDTO(
                grupo.getId(),
                grupo.getNombre(),
                grupo.getCodigoInvitacion()
        );
    }
}
