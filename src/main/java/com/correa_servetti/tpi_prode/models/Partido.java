package com.correa_servetti.tpi_prode.models;

import com.correa_servetti.tpi_prode.models.enums.ESTADO_PARTIDO;
import com.correa_servetti.tpi_prode.models.enums.TENDENCIA_PARTIDO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    LocalDateTime fechaInicio;

    @Column(nullable = false)
    int golesLocal = 0;

    @Column(nullable = false)
    int golesVisitante = 0;

    @Column(nullable = false)
    ESTADO_PARTIDO estado = ESTADO_PARTIDO.POR_JUGARSE;

    @Column(nullable = false)
    TENDENCIA_PARTIDO tendencia =  TENDENCIA_PARTIDO.EMPATE;

    @ManyToOne
    @JoinColumn(name = "fecha_id")
    Fecha fecha;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    Equipo equipoVisitante;
}
