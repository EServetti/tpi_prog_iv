package com.correa_servetti.tpi_prode.controllers;

import com.correa_servetti.tpi_prode.dto.*;
import com.correa_servetti.tpi_prode.models.MiembroGrupo;
import com.correa_servetti.tpi_prode.service.GrupoService;
import com.correa_servetti.tpi_prode.service.MiembroGrupoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grupos")
@RequiredArgsConstructor
public class GrupoController {
    private final GrupoService grupoService;
    private final MiembroGrupoService miembroGrupoService;

    @PostMapping
    public GrupoResponseDTO crearGrupo(@RequestBody GrupoRequestDTO dto){
        return grupoService.crear(dto);
    }

    @PutMapping("/{id}")
    public GrupoResponseDTO actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarGrupoRequestDTO dto){
        return grupoService.actualizar(id, dto);
    }

    @PostMapping("/ingresar")
    public MiembroGrupoResponseDTO ingresar(@RequestBody IngresarGrupoRequestDTO dto){
        return miembroGrupoService.ingresarAGrupo(dto);
    }

    @PutMapping("/expulsar")
    public MiembroGrupoResponseDTO expulsar(@RequestBody ExpulsarGrupoRequestDTO dto){
        return miembroGrupoService.expulsarDeGrupo(dto.getUsuarioId(), dto.getGrupoId());
    }

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
