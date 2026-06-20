package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.models.Fecha;
import com.correa_servetti.tpi_prode.repository.FechaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FechaService {
    private final FechaRepository fechaRepository;

    public Fecha guardar(Fecha fecha){
        return fechaRepository.save(fecha);
    }

    public List<Fecha> listar(){
        return fechaRepository.findAll();
    }

    public Fecha buscarPorId(Integer id){
        return fechaRepository.findById(id).orElseThrow(()-> new RuntimeException("Fecha no encontrada"));
    }

    public void eliminar(Integer id){
        fechaRepository.deleteById(id);
    }
}
