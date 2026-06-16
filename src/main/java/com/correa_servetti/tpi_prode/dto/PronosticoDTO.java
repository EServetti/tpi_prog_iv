package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.Partido;
import com.correa_servetti.tpi_prode.models.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PronosticoDTO {
    @NotNull(message = "Ingrese los goles del local")
    Integer golesLocal;

    @NotNull(message = "Ingrese los goles del visitante")
    Integer golesVisitante;

    @NotNull(message = "Ingrese el usuario")
    Usuario usuario;

    @NotNull(message = "Ingrese el partidos")
    Partido partido;

    LocalDateTime fechaPronostico =  LocalDateTime.now();

    Integer puntosObtenidos = 0;
}
