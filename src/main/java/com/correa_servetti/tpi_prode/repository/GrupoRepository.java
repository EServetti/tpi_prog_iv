package com.correa_servetti.tpi_prode.repository;

import com.correa_servetti.tpi_prode.models.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GrupoRepository extends JpaRepository<Grupo, Long> {
    Optional<Grupo> findByCodigoInvitacion(String codigoInvitacion);
}
