package com.correa_servetti.tpi_prode.controllers;

import com.correa_servetti.tpi_prode.dto.ActualizarPartidoRequestDTO;
import com.correa_servetti.tpi_prode.dto.CrearPartidoRequestDTO;
import com.correa_servetti.tpi_prode.models.Partido;
import com.correa_servetti.tpi_prode.service.PartidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Partidos",
        description = "Gestión de partidos"
)
@RestController
@RequestMapping("/partidos")
@RequiredArgsConstructor
public class PartidoController {

    private final PartidoService partidoService;

    @Operation(
            summary = "Crear partido",
            description = "Crea un partido indicando equipos, fecha y horario."
    )
    @PostMapping
    public Partido crear(
            @RequestBody CrearPartidoRequestDTO dto){
        return partidoService.crearPartido(
                dto.getEquipoLocalId(),
                dto.getEquipoVisitanteId(),
                dto.getFechaId(),
                dto.getFechaInicio()
        );
    }

    @Operation(
            summary = "Actualizar partido",
            description = "Permite actualizar fecha, estado y resultado de un partido."
    )
    @PutMapping("/{id}")
    public Partido actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarPartidoRequestDTO dto){
        return partidoService.actualizarPartido(
                id,
                dto.getFechaId(),
                dto.getFechaInicio(),
                dto.getGolesLocal(),
                dto.getGolesVisitante(),
                dto.getEstado()
        );
    }

    @Operation(
            summary = "Listar partidos",
            description = "Obtiene todos los partidos registrados."
    )
    @GetMapping
    public List<Partido> listar(){
        return partidoService.listar();
    }
}