package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.dto.IngresarGrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.MiembroGrupoRequestDTO;
import com.correa_servetti.tpi_prode.dto.MiembroGrupoResponseDTO;
import com.correa_servetti.tpi_prode.mappers.MiembroGrupoMapper;
import com.correa_servetti.tpi_prode.models.Grupo;
import com.correa_servetti.tpi_prode.models.MiembroGrupo;
import com.correa_servetti.tpi_prode.models.Usuario;
import com.correa_servetti.tpi_prode.models.enums.ESTADO_INVITACION;
import com.correa_servetti.tpi_prode.models.enums.ROL_MIEMBRO;
import com.correa_servetti.tpi_prode.repository.MiembroGrupoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MiembroGrupoService {
    private final MiembroGrupoRepository miembroGrupoRepository;
    private final UsuarioService usuarioService;
    private final GrupoService grupoService;

    public MiembroGrupoResponseDTO crear(
            MiembroGrupoRequestDTO dto){
        MiembroGrupo miembro =
                MiembroGrupoMapper.toEntity(dto);

        miembro = miembroGrupoRepository.save(miembro);

        return MiembroGrupoMapper.toResponseDTO(miembro);
    }

    public List<MiembroGrupo> listar(){
        return miembroGrupoRepository.findAll();
    }

    public MiembroGrupo buscarPorId(Long id){
        return miembroGrupoRepository.findById(id)
                .orElseThrow(()->
                        new RuntimeException(
                                "Miembro no encontrado"));
    }

    public MiembroGrupoResponseDTO ingresarAGrupo(
            IngresarGrupoRequestDTO dto){
        Usuario usuario = usuarioService.buscarPorId(dto.getUsuarioId());

        Grupo grupo = grupoService.buscarPorId(dto.getGrupoId());

        if (!grupo.getCodigoInvitacion().equals(dto.getCodigoInvitacion())){
            throw new RuntimeException("Codigo de invitacion incorrecto");
        }
        MiembroGrupo miembro = new MiembroGrupo();

        miembro.setMiembro(usuario);
        miembro.setGrupo(grupo);
        miembro.setCodigoInvitacion(dto.getCodigoInvitacion());
        miembro.setRol(ROL_MIEMBRO.USUARIO);
        miembro.setEstado(ESTADO_INVITACION.ACEPTADA);

        miembro = miembroGrupoRepository.save(miembro);

        return MiembroGrupoMapper.toResponseDTO(miembro);
    }

    public MiembroGrupoResponseDTO expulsarDeGrupo(
            Long usuarioId, Long grupoId){
        MiembroGrupo miembro = miembroGrupoRepository
                .findByMiembroIdAndGrupoId(
                        usuarioId,
                        grupoId)
                .orElseThrow(() -> new RuntimeException("Miembro no encontrado"));

        miembro.setEstado(ESTADO_INVITACION.RECHAZADA);
        miembro = miembroGrupoRepository.save(miembro);

        return MiembroGrupoMapper.toResponseDTO(miembro);
    }

    public List<MiembroGrupo> obtenerPorUsuario(
            Long usuarioId){
        return miembroGrupoRepository.findByMiembroId(usuarioId);
    }

    public void eliminar(Long id){
        miembroGrupoRepository.deleteById(id);
    }
}
