package com.correa_servetti.tpi_prode.controllers;

import com.correa_servetti.tpi_prode.dto.*;
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

    @Operation(summary = "Crear grupo", description = "Crea un nuevo grupo usando nombre y doc. de invitacion")
    @PostMapping
    public GrupoResponseDTO crearGrupo(@RequestBody GrupoRequestDTO dto){
        return grupoService.crear(dto);
    }

    @Operation(summary = "Ingresar a un grupo",
            description = "Permite a un usuario ingresar a un grupo mediante el código de invitación")
    @PostMapping("/ingresar")
    public MiembroGrupoResponseDTO ingresar(@RequestBody IngresarGrupoRequestDTO dto){
        return miembroGrupoService.ingresarAGrupo(dto);
    }

    @Operation(summary = "Expulsar usuario de grupo",
    description = "Cambia el estado del miembro a RECHAZADA dentro del grupo")
    @PutMapping("/expulsar")
    public MiembroGrupoResponseDTO expulsar(@RequestBody ExpulsarGrupoRequestDTO dto){
        return miembroGrupoService.expulsarDeGrupo(dto.getUsuarioId(), dto.getGrupoId());
    }

    @Operation(summary = "Obtener grupos de un usuario",
    description = "Retorna todos los grupos donde participa el usuario indicado")
    @GetMapping("/usuario/{idUsuario}")
    public List<GrupoConParticipantesDTO> gruposDeUsuario(
            @PathVariable Long idUsuario){
        return miembroGrupoService.obtenerPorUsuario(idUsuario);
    }

    @Operation(summary = "Listar miembros de un grupo",
    description = "Obtiene todos los miembros asociados a un grupo")
    @GetMapping("/{id}/miembros")
    public List<MiembroGrupoResponseDTO> miembrosDeGrupo(
            @PathVariable Long id){
        return grupoService.obtenerMiembros(id);
    }
}
