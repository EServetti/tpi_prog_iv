package com.correa_servetti.tpi_prode.mappers;

import com.correa_servetti.tpi_prode.dto.FechaRequestDTO;
import com.correa_servetti.tpi_prode.dto.FechaResponseDTO;
import com.correa_servetti.tpi_prode.models.Fecha;
import org.hibernate.grammars.hql.HqlParser;

public class FechaMapper {
    public static Fecha toEntity(FechaRequestDTO dto){
        Fecha fecha = new Fecha();

        fecha.setEstadoFecha(dto.getEstado());

        return fecha;
    }

    public static FechaResponseDTO toResponseDTo(Fecha fecha){
        return new FechaResponseDTO(
                fecha.getId(),
                fecha.getEstadoFecha()
        );
    }
}
