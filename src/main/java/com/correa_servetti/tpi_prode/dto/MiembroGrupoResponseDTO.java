package com.correa_servetti.tpi_prode.dto;

import com.correa_servetti.tpi_prode.models.Grupo;
import com.correa_servetti.tpi_prode.models.Usuario;
import com.correa_servetti.tpi_prode.models.enums.ESTADO_INVITACION;
import com.correa_servetti.tpi_prode.models.enums.ROL_MIEMBRO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MiembroGrupoResponseDTO {
    @NotNull
    Long id;

    @NotNull
    Usuario usuario;

    @NotNull
    Grupo grupo;

    @NotBlank
    String codigoInvitacion;

    @NotBlank
    ROL_MIEMBRO rol;

    @NotBlank
    ESTADO_INVITACION estado;

    long puntos;

    long resultadosExactos;

    List<FechaPronosticoDTO> fechaPronosticos;
}
