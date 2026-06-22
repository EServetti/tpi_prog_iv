package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.dto.PronosticoRequestDTO;
import com.correa_servetti.tpi_prode.dto.PronosticoResponseDTO;
import com.correa_servetti.tpi_prode.mappers.PronosticoMapper;
import com.correa_servetti.tpi_prode.models.Partido;
import com.correa_servetti.tpi_prode.models.Pronostico;
import com.correa_servetti.tpi_prode.models.Usuario;
import com.correa_servetti.tpi_prode.repository.PronosticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PronosticoService {
    private final PronosticoRepository pronosticoRepository;
    private final UsuarioService usuarioService;
    private PartidoService partidoService;

    public PronosticoResponseDTO crear(
            PronosticoRequestDTO dto){
        Pronostico pronostico = PronosticoMapper.toEntity(dto);

        pronostico = pronosticoRepository.save(pronostico);

        return PronosticoMapper
                .toResponseDTO(pronostico);
    }

    public List<Pronostico> listar(){
        return pronosticoRepository.findAll();
    }

    public Pronostico buscarPorId(Long id){
        return pronosticoRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Pronostico no encontrado"));
    }

    public void eliminar(Long id){
        pronosticoRepository.deleteById(id);
    }

    public Pronostico crearPronostico(
            Long usuarioId,
            Long partidoId,
            Integer golesLocal,
            Integer golesVisitante){
        Usuario usuario = usuarioService.buscarPorId(usuarioId);

        Partido partido = partidoService.buscarPorId(partidoId);

        Pronostico pronostico = new Pronostico();

        pronostico.setUsuario(usuario);
        pronostico.setPartido(partido);
        pronostico.setGolesLocal(golesLocal);
        pronostico.setGolesVisitante(golesVisitante);

        pronostico.setFechaPronostico(LocalDateTime.now());

        pronostico.setPuntosObtenidos(0);

        return pronosticoRepository.save(pronostico);
    }

    public Pronostico actualizarPronostico(
            Long pronosticoId,
            Integer golesLocal,
            Integer golesVisitante){
        Pronostico pronostico = buscarPorId(pronosticoId);

        if (golesLocal != null){
            pronostico.setGolesLocal(golesLocal);
        }

        if (golesVisitante != null){
            pronostico.setGolesVisitante(golesVisitante);
        }

        return pronosticoRepository.save(pronostico);
    }

    public List<Pronostico> obtenerPorUsuario(
            Long usuarioId){
        return pronosticoRepository.findByUsuarioId(usuarioId);
    }
}
