package com.correa_servetti.tpi_prode.controllers;

import com.correa_servetti.tpi_prode.dto.*;
import com.correa_servetti.tpi_prode.models.MiembroGrupo;
import com.correa_servetti.tpi_prode.service.GrupoService;
import com.correa_servetti.tpi_prode.service.MiembroGrupoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Grupos",
        description = "Gestion de grupos y miembros"
)
@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GrupoController {
    private final GrupoService grupoService;
    private final MiembroGrupoService miembroGrupoService;

    @Operation(summary = "Crear grupo")
    @PostMapping
    public GrupoResponseDTO crearGrupo(@RequestBody GrupoRequestDTO dto){
        return grupoService.crear(dto);
    }

    @Operation(summary = "Ingresar a un grupo")
    @PostMapping("/ingresar")
    public MiembroGrupoResponseDTO ingresar(@RequestBody IngresarGrupoRequestDTO dto){
        return miembroGrupoService.ingresarAGrupo(dto);
    }

    @Operation(summary = "Expulsar usuario de grupo")
    @PutMapping("/expulsar")
    public MiembroGrupoResponseDTO expulsar(@RequestBody ExpulsarGrupoRequestDTO dto){
        return miembroGrupoService.expulsarDeGrupo(dto.getUsuarioId(), dto.getGrupoId());
    }

    @Operation(summary = "Obtener grupos de un usuario")
    @GetMapping("/usuario/{idUsuario}")
    public List<GrupoConParticipantesDTO> gruposDeUsuario(
            @PathVariable Long idUsuario){
        return miembroGrupoService.obtenerPorUsuario(idUsuario);
    }

    @GetMapping("/{id}/miembros")
    public List<MiembroGrupo> miembrosDeGrupo(
            @PathVariable Long id){
        return grupoService.obtenerMiembros(id);
    }
}
