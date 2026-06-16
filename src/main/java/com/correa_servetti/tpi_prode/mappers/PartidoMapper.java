package com.correa_servetti.tpi_prode.mappers;

import com.correa_servetti.tpi_prode.dto.PartidoRequestDTO;
import com.correa_servetti.tpi_prode.dto.PartidoResponseDTO;
import com.correa_servetti.tpi_prode.models.Partido;
import jakarta.servlet.http.Part;

public class PartidoMapper {
    public static Partido toEntity(PartidoRequestDTO dto){
        Partido partido = new Partido();

        partido.setFechaInicio(dto.getFechaInicio().atStartOfDay());
        partido.setFecha(dto.getFecha());
        partido.setEquipoLocal(dto.getEquipoLocal());
        partido.setEquipoVisitante(dto.getEquipoVisitante());
        partido.setGolesLocal(dto.getGolesLocal());
        partido.setGolesVisitante(dto.getGolesVisitante());
        partido.setEstado(dto.getEstadoPartido());
        partido.setTendencia(dto.getTendenciaPartido());

        return partido;
    }
    public static PartidoResponseDTO toResponseDTO(Partido partido){
        return new PartidoResponseDTO(
                partido.getId(),
                partido.getFechaInicio(),
                partido.getGolesLocal(),
                partido.getGolesVisitante(),
                partido.getEstado(),
                partido.getTendencia(),
                partido.getFecha(),
                partido.getEquipoLocal(),
                partido.getEquipoVisitante()
        );
    }
}
