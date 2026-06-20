package com.correa_servetti.tpi_prode.service;

import com.correa_servetti.tpi_prode.dto.LoginRequestDTO;
import com.correa_servetti.tpi_prode.dto.LoginResponseDTO;
import com.correa_servetti.tpi_prode.dto.RegisterRequestDTO;
import com.correa_servetti.tpi_prode.dto.UsuarioResponseDTO;
import com.correa_servetti.tpi_prode.models.Usuario;
import com.correa_servetti.tpi_prode.models.enums.ROL;
import com.correa_servetti.tpi_prode.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public LoginResponseDTO register(RegisterRequestDTO request){
        if (usuarioRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("El email ya esta registrado");
        }

        Usuario usuario = new Usuario();

        usuario.setEmail(request.getEmail());
        usuario.setNombreUsuario(request.getNombreUsuario());

        usuario.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        usuario.setRol(ROL.USUARIO);

        usuario.setFechaRegistro(LocalDate.now());

        usuarioRepository.save(usuario);

        String token = jwtService.generateToken(usuario);

        return new LoginResponseDTO(token);
    }

    public LoginResponseDTO login(LoginRequestDTO request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        Usuario usuario = usuarioRepository
                .findByEmail(request.getEmail())
                .orElseThrow();

        String token = jwtService.generateToken(usuario);

        return new LoginResponseDTO(token);
    }

    public UsuarioResponseDTO obtenerUsuario(String email){
        Usuario usuario = usuarioRepository
                .findByEmail(email)
                .orElseThrow();

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
