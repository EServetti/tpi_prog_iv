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
    private LocalDateTime fechaPronostico;

    @Column(nullable = false)
    private Integer puntosObtenidos;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

    public boolean resultadoExacto(){
        return golesLocal.equals(partido.getGolesLocal())
                && golesVisitante.equals(partido.getGolesVisitante());
    }

    public boolean acierta(){
        return obtenerTendenciaPronosticada() == partido.getTendencia();
    }

    public void calcularPts(){
        if (resultadoExacto()){
            puntosObtenidos = 3;
        } else if (acierta()) {
            puntosObtenidos = 1;
        } else {
            puntosObtenidos = 0;
        }
    }

    public  void actualizarResultado(){
        calcularPts();
    }

    private TENDENCIA_PARTIDO obtenerTendenciaPronosticada(){
        if (golesLocal > golesVisitante){
            return TENDENCIA_PARTIDO.LOCAL;
        }

        if (golesLocal < golesVisitante){
            return TENDENCIA_PARTIDO.VISITANTE;
        }

        return TENDENCIA_PARTIDO.EMPATE;
    }
}
