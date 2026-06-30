package com.correa_servetti.tpi_prode.mappers;

import com.correa_servetti.tpi_prode.dto.FechaPronosticoDTO;
import com.correa_servetti.tpi_prode.dto.MiembroGrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.MiembroGrupoResponseDTO;
import com.correa_servetti.tpi_prode.models.MiembroGrupo;

import java.util.List;

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
        List<FechaPronosticoDTO> fechaPronosticos = miembroGrupo.getFechaPronosticos()
                .stream()
                .map(fp -> new FechaPronosticoDTO(
                        fp.getFechaId(),
                        fp.getPartidoId(),
                        fp.getFechaPronostico()
                ))
                .toList();

        return new MiembroGrupoResponseDTO(
                miembroGrupo.getId(),
                miembroGrupo.getMiembro(),
                miembroGrupo.getGrupo(),
                miembroGrupo.getCodigoInvitacion(),
                miembroGrupo.getRol(),
                miembroGrupo.getEstado(),
                miembroGrupo.getPuntos(),
                miembroGrupo.getResultadosExactos(),
                fechaPronosticos
        );
    }
}
