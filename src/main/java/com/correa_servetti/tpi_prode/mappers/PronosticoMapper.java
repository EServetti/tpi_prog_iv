package com.correa_servetti.tpi_prode.mappers;

import com.correa_servetti.tpi_prode.dto.PronosticoRequestDTO;
import com.correa_servetti.tpi_prode.dto.PronosticoResponseDTO;
import com.correa_servetti.tpi_prode.models.Pronostico;

public class PronosticoMapper {
    public static Pronostico toEntity(PronosticoRequestDTO dto){
        Pronostico pronostico = new Pronostico();

        pronostico.setGolesLocal(dto.getGolesLocal());
        pronostico.setGolesVisitante(dto.getGolesVisitante());
        pronostico.setUsuario(dto.getUsuario());
        pronostico.setPartido(dto.getPartido());
        pronostico.setFechaPronostico(dto.getFechaPronostico());
        pronostico.setPuntosObtenidos(dto.getPuntosObtenidos());

        return pronostico;
    }
    public static PronosticoResponseDTO toResponseDTO(Pronostico pronostico){
        return new PronosticoResponseDTO(
                pronostico.getId(),
                pronostico.getGolesLocal(),
                pronostico.getGolesVisitante(),
                pronostico.getFechaPronostico(),
                pronostico.getPuntosObtenidos(),
                pronostico.getUsuario(),
                pronostico.getPartido()
        );
    }
}
