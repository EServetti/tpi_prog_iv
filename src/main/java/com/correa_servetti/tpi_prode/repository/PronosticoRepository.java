package com.correa_servetti.tpi_prode.repository;

import com.correa_servetti.tpi_prode.models.Pronostico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {
}
