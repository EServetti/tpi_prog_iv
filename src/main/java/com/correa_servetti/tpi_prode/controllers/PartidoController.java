package com.correa_servetti.tpi_prode.controllers;

import com.correa_servetti.tpi_prode.dto.ActualizarPartidoRequestDTO;
import com.correa_servetti.tpi_prode.dto.CrearPartidoRequestDTO;
import com.correa_servetti.tpi_prode.models.Partido;
import com.correa_servetti.tpi_prode.service.PartidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partidos")
@RequiredArgsConstructor
public class PartidoController {
    private final PartidoService partidoService;

    @PostMapping
    public Partido crear(
            @RequestBody
            CrearPartidoRequestDTO dto){
        return partidoService.crearPartido(dto.getEquipoLocalId(),
                dto.getEquipoVisitanteId(),
                dto.getFechaId(),
                dto.getFechaInicio());
    }

    @PutMapping("/{id}")
    public Partido actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarPartidoRequestDTO dto){
        return partidoService.actualizarPartido(
                id,
                dto.getFechaId(),
                dto.getFechaInicio(),
                dto.getGolesLocal(),
                dto.getGolesVisitante()
        );
    }
    @GetMapping
    public List<Partido> listar(){
        return partidoService.listar();
    }
}
