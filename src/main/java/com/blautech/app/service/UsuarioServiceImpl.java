package com.blautech.app.service;

import com.blautech.app.entity.Usuario;
import com.blautech.app.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepo;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario crear(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public List<Usuario> listar() {
        return usuarioRepo.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public Usuario actualizar(Integer id, Usuario usuario) {
        Usuario existente = usuarioRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        existente.setNombre(usuario.getNombre());
        existente.setApellido(usuario.getApellido());
        existente.setDireccionEnvio(usuario.getDireccionEnvio());
        existente.setEmail(usuario.getEmail());
        existente.setFechaNacimiento(usuario.getFechaNacimiento());
        existente.setPassword(usuario.getPassword());

        return usuarioRepo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepo.deleteById(id);
    }
}
