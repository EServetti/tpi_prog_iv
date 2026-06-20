package com.correa_servetti.tpi_prode.controllers;

import com.correa_servetti.tpi_prode.dto.LoginRequestDTO;
import com.correa_servetti.tpi_prode.dto.LoginResponseDTO;
import com.correa_servetti.tpi_prode.dto.RegisterRequestDTO;
import com.correa_servetti.tpi_prode.dto.UsuarioResponseDTO;
import com.correa_servetti.tpi_prode.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<LoginResponseDTO> register(
            @RequestBody RegisterRequestDTO request){

        return ResponseEntity.ok(
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(
            @RequestBody LoginRequestDTO request){

        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioResponseDTO> me(
            Authentication authentication){
        return ResponseEntity.ok(
                authService.obtenerUsuario(
                        authentication.getName()
                )
        );
    }
}
