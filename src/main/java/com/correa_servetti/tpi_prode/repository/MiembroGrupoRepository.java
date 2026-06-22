package com.correa_servetti.tpi_prode.repository;

import com.correa_servetti.tpi_prode.models.MiembroGrupo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MiembroGrupoRepository extends JpaRepository<MiembroGrupo, Long> {
    List<MiembroGrupo> findByMiembroId(Long usuarioId);

    Optional<MiembroGrupo> findByMiembroIdAndGrupoId(
            Long usuarioId,
            Long grupoId
    );
}
