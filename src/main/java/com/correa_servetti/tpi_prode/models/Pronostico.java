package com.correa_servetti.tpi_prode.models;

import com.correa_servetti.tpi_prode.models.enums.TENDENCIA_PARTIDO;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Pronostico{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer golesLocal;

    @Column(nullable = false)
    private Integer golesVisitante;

    @Column(nullable = false)
    private LocalDateTime fechaPronostico = LocalDateTime.now();

    @Column(nullable = false)
    private Integer puntosObtenidos = 0;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;
}
