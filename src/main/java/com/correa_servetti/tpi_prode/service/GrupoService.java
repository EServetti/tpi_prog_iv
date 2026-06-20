package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.dto.GrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.GrupoResponseDTO;
import com.correa_servetti.tpi_prode.mappers.GrupoMapper;
import com.correa_servetti.tpi_prode.models.Grupo;
import com.correa_servetti.tpi_prode.repository.GrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoService {
    private final GrupoRepository grupoRepository;

    public GrupoResponseDTO crear(GrupoRequestDTO dto){
        Grupo grupo = GrupoMapper.toEntity(dto);
        grupo = grupoRepository.save(grupo);

        return GrupoMapper.toResponseDTO(grupo);
    }

    public List<Grupo> listar(){
        return grupoRepository.findAll();
    }

    public Grupo buscarPorId(Long id){
        return grupoRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Grupo no encontrado") );
    }

    public void eliminar(Long id){
        grupoRepository.deleteById(id);
    }
}
