package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.dto.ActualizarGrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.GrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.GrupoResponseDTO;
import com.correa_servetti.tpi_prode.dto.MiembroGrupoResponseDTO;
import com.correa_servetti.tpi_prode.dto.ParticipanteGrupoDTO;
import com.correa_servetti.tpi_prode.mappers.GrupoMapper;
import com.correa_servetti.tpi_prode.mappers.MiembroGrupoMapper;
import com.correa_servetti.tpi_prode.models.Grupo;
import com.correa_servetti.tpi_prode.models.MiembroGrupo;
import com.correa_servetti.tpi_prode.models.Usuario;
import com.correa_servetti.tpi_prode.models.enums.ESTADO_INVITACION;
import com.correa_servetti.tpi_prode.models.enums.ROL_MIEMBRO;
import com.correa_servetti.tpi_prode.repository.GrupoRepository;
import com.correa_servetti.tpi_prode.repository.MiembroGrupoRepository;
import com.correa_servetti.tpi_prode.repository.PronosticoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoService {
    private final GrupoRepository grupoRepository;
    private final MiembroGrupoRepository miembroGrupoRepository;
    private final PronosticoRepository pronosticoRepository;

    @Transactional
    public GrupoResponseDTO crear(GrupoRequestDTO dto){
        Grupo grupo = GrupoMapper.toEntity(dto);
        grupo = grupoRepository.save(grupo);

        Usuario creador = usuarioAutenticado();

        MiembroGrupo miembro = new MiembroGrupo();
        miembro.setMiembro(creador);
        miembro.setGrupo(grupo);
        miembro.setCodigoInvitacion(grupo.getCodigoInvitacion());
        miembro.setRol(ROL_MIEMBRO.CREADOR);
        miembro.setEstado(ESTADO_INVITACION.ACEPTADA);

        miembroGrupoRepository.save(miembro);

        return GrupoMapper.toResponseDTO(grupo);
    }

    public GrupoResponseDTO actualizar(Long id, ActualizarGrupoRequestDTO dto){
        Grupo grupo = buscarPorId(id);
        validarCreador(id);

        if (dto.getNombre() != null) {
            grupo.setNombre(dto.getNombre());
        }
        if (dto.getIcono() != null) {
            grupo.setIcono(dto.getIcono());
        }
        if (dto.getCodigoInvitacion() != null) {
            grupo.setCodigoInvitacion(dto.getCodigoInvitacion());
        }

        grupo = grupoRepository.save(grupo);
        return GrupoMapper.toResponseDTO(grupo);
    }

    public List<MiembroGrupoResponseDTO> obtenerMiembros(Long grupoId){
        List<MiembroGrupo> miembros = miembroGrupoRepository.findByGrupoIdAndEstado(
                grupoId,
                ESTADO_INVITACION.ACEPTADA
        );

        for (MiembroGrupo m : miembros) {
            m.setPuntos(pronosticoRepository.sumPuntosByUsuarioAndGrupo(
                    m.getMiembro().getId(), grupoId));
            m.setResultadosExactos(pronosticoRepository.countResultadosExactosByUsuarioAndGrupo(
                    m.getMiembro().getId(), grupoId));
            m.setFechaPronosticos(pronosticoRepository.findFechaPronosticosByUsuarioAndGrupo(
                    m.getMiembro().getId(), grupoId));
        }

        return miembros.stream()
                .map(MiembroGrupoMapper::toResponseDTO)
                .toList();
    }

    public List<Grupo> listar(){
        return grupoRepository.findAll();
    }

    public Grupo buscarPorId(Long id){
        return grupoRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException("Grupo no encontrado") );
    }

    public Grupo buscarPorCodigoInvitacion(String codigo){
        return grupoRepository.findByCodigoInvitacion(codigo)
                .orElseThrow(() ->
                        new RuntimeException("Codigo de invitacion invalido"));
    }

    public void eliminar(Long id){
        grupoRepository.deleteById(id);
    }

    private Usuario usuarioAutenticado(){
        return (Usuario) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }

    private void validarCreador(Long grupoId){
        Usuario usuario = usuarioAutenticado();
        MiembroGrupo miembro = miembroGrupoRepository
                .findByMiembroIdAndGrupoId(usuario.getId(), grupoId)
                .orElseThrow(() -> new AccessDeniedException(
                        "No pertenece al grupo"));

        if (miembro.getRol() != ROL_MIEMBRO.CREADOR) {
            throw new AccessDeniedException(
                    "Solo el creador del grupo puede realizar esta accion");
        }
    }
}
