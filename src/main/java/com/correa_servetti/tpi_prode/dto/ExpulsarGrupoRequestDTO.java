package com.correa_servetti.tpi_prode.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpulsarGrupoRequestDTO {
    private Long usuarioId;
    private Long grupoId;
}
