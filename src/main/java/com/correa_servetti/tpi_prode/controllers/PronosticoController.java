package com.correa_servetti.tpi_prode.controllers;

import com.correa_servetti.tpi_prode.dto.ActualizarPronosticoRequestDTO;
import com.correa_servetti.tpi_prode.dto.CrearPronosticoRequestDTO;
import com.correa_servetti.tpi_prode.models.Pronostico;
import com.correa_servetti.tpi_prode.service.PronosticoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pronosticos")
@RequiredArgsConstructor
public class PronosticoController {
    private final PronosticoService pronosticoService;

    @PostMapping
    public Pronostico crear(@RequestBody CrearPronosticoRequestDTO dto){
        return pronosticoService.crearPronostico(
                dto.getUsuarioId(),
                dto.getPartidoId(),
                dto.getGrupoId(),
                dto.getGolesLocal(),
                dto.getGolesVisitante()
        );
    }

    @PutMapping("{id}")
    public Pronostico actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarPronosticoRequestDTO dto
            ){
        return pronosticoService.actualizarPronostico(id, dto.getGolesLocal(), dto.getGolesVisitante());
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pronostico> obtenerPorUsuario(
            @PathVariable Long usuarioId
    ){
        return pronosticoService.obtenerPorUsuario(usuarioId);
    }
}
