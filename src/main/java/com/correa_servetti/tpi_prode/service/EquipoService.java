package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.models.Equipo;
import com.correa_servetti.tpi_prode.repository.EquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipoService {
    private final EquipoRepository equipoRepository;

    public Equipo guardar(Equipo equipo){
        return equipoRepository.save(equipo);
    }

    public List<Equipo> listar(){
        return equipoRepository.findAll();
    }

    public Equipo buscarPorId(Long id){
        return equipoRepository.findById(id).orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
    }

    public void eliminar(Long id){
        equipoRepository.deleteById(id);
    }
}
