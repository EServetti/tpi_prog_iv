package com.correa_servetti.tpi_prode.mappers;

import com.correa_servetti.tpi_prode.dto.EquipoRequestDTO;
import com.correa_servetti.tpi_prode.dto.EquipoResponseDTO;
import com.correa_servetti.tpi_prode.models.Equipo;

public class EquipoMapper {
    public static Equipo toEntity(EquipoRequestDTO dto){
        Equipo equipo = new Equipo();

        equipo.setNombre(dto.getNombre());

        return equipo;
    }
    public static EquipoResponseDTO toResponseDTO(Equipo equipo){
        return new EquipoResponseDTO(
                equipo.getId(),
                equipo.getNombre()
        );
    }
}
