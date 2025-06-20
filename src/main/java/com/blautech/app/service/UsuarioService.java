package com.blautech.app.service;


import com.blautech.app.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario crear(Usuario usuario);
    List<Usuario> listar();
    Optional<Usuario> buscarPorId(Integer id);
    Usuario actualizar(Integer id, Usuario usuario);
    void eliminar(Integer id);
}
