package com.correa_servetti.tpi_prode.mappers;

import com.correa_servetti.tpi_prode.dto.UsuarioRequestDTO;
import com.correa_servetti.tpi_prode.dto.UsuarioResponseDTO;
import com.correa_servetti.tpi_prode.models.Usuario;

import javax.swing.text.html.parser.Entity;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequestDTO dto){
        Usuario usuario = new Usuario();

        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setRol(dto.getRol());
        usuario.setFechaRegistro(dto.getFechaRegistro());

        return usuario;
    }
    public static UsuarioResponseDTO toResponseDTO(Usuario usuario){
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getEmail(),
                usuario.getPassword(),
                usuario.getNombreUsuario(),
                usuario.getRol(),
                usuario.getFechaRegistro()
        );
    }
}
