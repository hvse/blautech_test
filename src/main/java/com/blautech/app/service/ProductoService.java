package com.blautech.app.service;

import com.blautech.app.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto crear(Producto producto);
    List<Producto> listar();
    Optional<Producto> buscarPorId(Integer id);
    Producto actualizar(Integer id, Producto producto);
    void eliminar(Integer id);
}