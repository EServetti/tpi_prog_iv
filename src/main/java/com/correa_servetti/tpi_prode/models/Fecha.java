package com.correa_servetti.tpi_prode.models;

import com.correa_servetti.tpi_prode.models.enums.ESTADO_FECHA;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class Fecha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private ESTADO_FECHA estadoFecha;
}
