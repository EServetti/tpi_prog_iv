package com.correa_servetti.tpi_prode.mappers;

import com.correa_servetti.tpi_prode.dto.MiembroGrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.MiembroGrupoResponseDTO;
import com.correa_servetti.tpi_prode.models.MiembroGrupo;

public class MiembroGrupoMapper {
    public static MiembroGrupo toEntity(MiembroGrupoRequestDTO dto){
        MiembroGrupo miembroGrupo = new MiembroGrupo();

        miembroGrupo.setMiembro(dto.getUsuario());
        miembroGrupo.setGrupo(dto.getGrupo());
        miembroGrupo.setCodigoInvitacion(dto.getCodigoInvitacion());
        miembroGrupo.setRol(dto.getRol());
        miembroGrupo.setEstado(dto.getEstadoInvitacion());

        return miembroGrupo;
    }

    public static MiembroGrupoResponseDTO toResponseDTO(MiembroGrupo miembroGrupo){
        return new MiembroGrupoResponseDTO(
                miembroGrupo.getId(),
                miembroGrupo.getMiembro(),
                miembroGrupo.getGrupo(),
                miembroGrupo.getCodigoInvitacion(),
                miembroGrupo.getRol(),
                miembroGrupo.getEstado()
        );
    }
}
