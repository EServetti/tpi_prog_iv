package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.dto.MiembroGrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.MiembroGrupoResponseDTO;
import com.correa_servetti.tpi_prode.mappers.MiembroGrupoMapper;
import com.correa_servetti.tpi_prode.models.MiembroGrupo;
import com.correa_servetti.tpi_prode.repository.MiembroGrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiembroGrupoService {
    private final MiembroGrupoRepository miembroGrupoRepository;

    public MiembroGrupoResponseDTO crear(
            MiembroGrupoRequestDTO dto){
        MiembroGrupo miembro =
                MiembroGrupoMapper.toEntity(dto);

        miembro = miembroGrupoRepository.save(miembro);

        return MiembroGrupoMapper.toResponseDTO(miembro);
    }

    public List<MiembroGrupo> listar(){
        return miembroGrupoRepository.findAll();
    }

    public MiembroGrupo buscarPorId(Long id){
        return miembroGrupoRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException(
                                "Miembro no encontrado"));
    }

    public void eliminar(Long id){
        miembroGrupoRepository.deleteById(id);
    }
}
