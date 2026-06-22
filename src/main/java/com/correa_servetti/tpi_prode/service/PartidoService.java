package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.models.Equipo;
import com.correa_servetti.tpi_prode.models.Fecha;
import com.correa_servetti.tpi_prode.models.Partido;
import com.correa_servetti.tpi_prode.models.enums.ESTADO_PARTIDO;
import com.correa_servetti.tpi_prode.models.enums.TENDENCIA_PARTIDO;
import com.correa_servetti.tpi_prode.repository.PartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PartidoService {
    private final PartidoRepository partidoRepository;
    private final EquipoService equipoService;
    private final FechaService fechaService;

    public Partido guardar(Partido partido){
        return partidoRepository.save(partido);
    }

    public List<Partido> listar(){
        return partidoRepository.findAll();
    }

    public Partido buscarPorId(Long id){
        return partidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Partido no encontrado"));
    }

    public void eliminar(Long id){
        partidoRepository.deleteById(id);
    }

    public Partido crearPartido(Long equipoLocalId,
                                Long equipoVisitanteId,
                                Integer fechaId,
                                LocalDateTime fechaInicio){
        Equipo local = equipoService.buscarPorId(equipoLocalId);
        Equipo visitante = equipoService.buscarPorId(equipoVisitanteId);

        Fecha fecha = fechaService.buscarPorId(fechaId);

        Partido partido = new Partido();

        partido.setEquipoLocal(local);
        partido.setEquipoVisitante(visitante);
        partido.setFecha(fecha);
        partido.setFechaInicio(fechaInicio);

        partido.setGolesLocal(0);
        partido.setGolesVisitante(0);

        partido.setEstado(ESTADO_PARTIDO.POR_JUGARSE);
        partido.setTendencia(TENDENCIA_PARTIDO.EMPATE);

        return partidoRepository.save(partido);
    }

    public Partido actualizarPartido(
            Long partidoId,
            Integer fechaId,
            java.time.LocalDateTime fechaInicio,
            Integer golesLocal,
            Integer golesVisitante){
        Partido partido = buscarPorId(partidoId);

        if (fechaId != null){
            partido.setFecha(fechaService.buscarPorId(fechaId));
        }

        if (fechaInicio != null){
            partido.setFechaInicio(fechaInicio);
        }

        if (golesLocal != null){
            partido.setGolesLocal(golesLocal);
        }

        if (golesVisitante != null){
            partido.setGolesVisitante(golesVisitante);
        }

        if (partido.getGolesLocal() > partido.getGolesLocal()){
            partido.setTendencia(TENDENCIA_PARTIDO.LOCAL);
        } else if (partido.getGolesLocal()
        < partido.getGolesVisitante()){
            partido.setTendencia(TENDENCIA_PARTIDO.LOCAL);
        } else {
            partido.setTendencia(TENDENCIA_PARTIDO.EMPATE);
        }

        return partidoRepository.save(partido);
    }
}
