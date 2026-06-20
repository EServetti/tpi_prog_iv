package com.correa_servetti.tpi_prode.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {

    private String email;
    private String password;
    private String nombreUsuario;
}
