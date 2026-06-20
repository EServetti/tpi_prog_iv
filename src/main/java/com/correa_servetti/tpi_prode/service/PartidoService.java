package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.models.Partido;
import com.correa_servetti.tpi_prode.repository.PartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartidoService {
    private final PartidoRepository partidoRepository;

    public Partido guardar(Partido partido){
        return partidoRepository.save(partido);
    }

    public List<Partido> listar(){
        return partidoRepository.findAll();
    }

    public Partido buscarPorId(Long id){
        return partidoRepository.findById(id).orElseThrow(()-> new RuntimeException("Partido no encontrado"));
    }

    public void eliminar(Long id){
        partidoRepository.deleteById(id);
    }
}
