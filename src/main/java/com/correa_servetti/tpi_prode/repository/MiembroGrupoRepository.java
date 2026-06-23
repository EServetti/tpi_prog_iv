package com.correa_servetti.tpi_prode.repository;

import com.correa_servetti.tpi_prode.models.MiembroGrupo;
import com.correa_servetti.tpi_prode.models.enums.ESTADO_INVITACION;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MiembroGrupoRepository extends JpaRepository<MiembroGrupo, Long> {
    List<MiembroGrupo> findByMiembroId(Long usuarioId);

    List<MiembroGrupo> findByMiembroIdAndEstado(
            Long usuarioId,
            ESTADO_INVITACION estado
    );

    Optional<MiembroGrupo> findByMiembroIdAndGrupoId(
            Long usuarioId,
            Long grupoId
    );

    List<MiembroGrupo> findByGrupoIdAndEstado(
            Long grupoId,
            ESTADO_INVITACION estado
    );

    long countByGrupoIdAndEstado(
            Long grupoId,
            ESTADO_INVITACION estado
    );
}
