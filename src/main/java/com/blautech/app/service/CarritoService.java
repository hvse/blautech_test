package com.blautech.app.service;

import com.blautech.app.entity.Carrito;

import java.util.List;
import java.util.Optional;

public interface CarritoService {
    Carrito crear(Carrito carrito);
    List<Carrito> listar();
    Optional<Carrito> buscarPorId(Integer id);
    Carrito actualizar(Integer id, Carrito carrito);
    void eliminar(Integer id);
}