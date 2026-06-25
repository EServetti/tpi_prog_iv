package com.correa_servetti.tpi_prode.controllers;

import com.correa_servetti.tpi_prode.dto.ActualizarPronosticoRequestDTO;
import com.correa_servetti.tpi_prode.dto.CrearPronosticoRequestDTO;
import com.correa_servetti.tpi_prode.models.Pronostico;
import com.correa_servetti.tpi_prode.service.PronosticoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Pronósticos",
        description = "Gestión de pronósticos de partidos"
)
@RestController
@RequestMapping("/pronosticos")
@RequiredArgsConstructor
public class PronosticoController {

    private final PronosticoService pronosticoService;

    @Operation(
            summary = "Crear pronóstico",
            description = "Registra un pronóstico para un partido dentro de un grupo."
    )
    @PostMapping
    public Pronostico crear(
            @RequestBody CrearPronosticoRequestDTO dto){
        return pronosticoService.crearPronostico(
                dto.getUsuarioId(),
                dto.getPartidoId(),
                dto.getGrupoId(),
                dto.getGolesLocal(),
                dto.getGolesVisitante()
        );
    }

    @Operation(
            summary = "Actualizar pronóstico",
            description = "Actualiza los goles pronosticados para un partido."
    )
    @PutMapping("/{id}")
    public Pronostico actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarPronosticoRequestDTO dto){
        return pronosticoService.actualizarPronostico(
                id,
                dto.getGolesLocal(),
                dto.getGolesVisitante()
        );
    }

    @Operation(
            summary = "Obtener pronósticos de un usuario",
            description = "Lista todos los pronósticos realizados por un usuario."
    )
    @GetMapping("/usuario/{usuarioId}")
    public List<Pronostico> obtenerPorUsuario(
            @PathVariable Long usuarioId){
        return pronosticoService.obtenerPorUsuario(usuarioId);
    }
}