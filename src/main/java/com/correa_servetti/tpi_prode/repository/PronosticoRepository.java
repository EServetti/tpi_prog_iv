package com.correa_servetti.tpi_prode.repository;

import com.correa_servetti.tpi_prode.models.FechaPronostico;
import com.correa_servetti.tpi_prode.models.Pronostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PronosticoRepository extends JpaRepository<Pronostico, Long> {
    List<Pronostico> findByUsuarioId(Long usuarioId);

    @Query("SELECT new com.correa_servetti.tpi_prode.models.FechaPronostico(" +
           "p.partido.fecha.id, p.partido.id, p.fechaPronostico) " +
           "FROM Pronostico p " +
           "WHERE p.usuario.id = :usuarioId AND p.grupo.id = :grupoId")
    List<FechaPronostico> findFechaPronosticosByUsuarioAndGrupo(
            @Param("usuarioId") Long usuarioId,
            @Param("grupoId") Long grupoId);

    @Query("SELECT COALESCE(SUM(p.puntosObtenidos), 0) " +
           "FROM Pronostico p " +
           "WHERE p.usuario.id = :usuarioId AND p.grupo.id = :grupoId")
    long sumPuntosByUsuarioAndGrupo(
            @Param("usuarioId") Long usuarioId,
            @Param("grupoId") Long grupoId);

    @Query("SELECT COUNT(p) " +
           "FROM Pronostico p " +
           "WHERE p.usuario.id = :usuarioId " +
           "AND p.grupo.id = :grupoId " +
           "AND p.puntosObtenidos = 3")
    long countResultadosExactosByUsuarioAndGrupo(
            @Param("usuarioId") Long usuarioId,
            @Param("grupoId") Long grupoId);
}
