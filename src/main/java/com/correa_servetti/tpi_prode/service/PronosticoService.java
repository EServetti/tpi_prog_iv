package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.dto.PronosticoRequestDTO;
import com.correa_servetti.tpi_prode.dto.PronosticoResponseDTO;
import com.correa_servetti.tpi_prode.mappers.PronosticoMapper;
import com.correa_servetti.tpi_prode.models.Pronostico;
import com.correa_servetti.tpi_prode.repository.PronosticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PronosticoService {
    private final PronosticoRepository pronosticoRepository;

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
}
