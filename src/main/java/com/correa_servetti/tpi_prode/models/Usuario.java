package com.correa_servetti.tpi_prode.models;

import com.correa_servetti.tpi_prode.models.enums.ROL;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    String email;

    @Column(unique = true, nullable = false)
    String password;

    @Column(nullable = false)
    String nombreUsuario;

    @Column(nullable = false)
    ROL rol;

    @Column
    LocalDate fechaRegistro;
}
