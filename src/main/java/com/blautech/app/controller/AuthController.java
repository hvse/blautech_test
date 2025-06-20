package com.blautech.app.controller;

import com.blautech.app.DTO.AuthRequest;
import com.blautech.app.DTO.AuthResponse;
import com.blautech.app.entity.Usuario;
import com.blautech.app.repository.UsuarioRepository;
import com.blautech.app.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository usuarioRepo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioRepository usuarioRepo, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @Operation(
            summary = "Registrar un usuario",
            description = "Registrar un usuario"
    )
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepo.save(usuario);
        return ResponseEntity.ok("Registrado");
    }

    @Operation(
            summary = "Login de acceso",
            description = "Login de acceso"
    )
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        Usuario usuario = usuarioRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        log.info("aca abajo deberia mostrar el usuario que busca");
        log.info(usuario.toString());
        log.info("pass de la base: "+usuario.getPassword()+" pass del front: "+request.getPassword());
        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }
        log.info("llega aqui");
        String token = jwtUtil.generarToken(usuario.getEmail());
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
