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
public class PronosticoResponseDTO {
    @NotNull
    Long id;

    @NotNull
    int golesLocal;

    @NotNull
    int golesVisitante;

    @NotNull
    LocalDateTime fechaPronostico;

    @NotNull
    int puntosObtenidos = 0;

    @NotNull
    Usuario usuario;

    @NotNull
    Partido partido;
}
