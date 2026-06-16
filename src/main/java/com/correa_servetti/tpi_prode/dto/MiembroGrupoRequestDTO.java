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

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MiembroGrupoRequestDTO {
    @NotNull(message = "Ingrese el usuario")
    Usuario usuario;

    @NotNull(message = "Ingrese el grupo")
    Grupo grupo;

    @NotNull(message = "Ingrese el codigo de invitacion")
    @NotBlank(message = "Ingrese el codigo de invitacion")
    String codigoInvitacion;

    ROL_MIEMBRO rol = ROL_MIEMBRO.USUARIO;

    ESTADO_INVITACION estadoInvitacion = ESTADO_INVITACION.PENDIENTE;
}
