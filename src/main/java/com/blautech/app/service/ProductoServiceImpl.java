package com.blautech.app.service;

import com.blautech.app.entity.Producto;
import com.blautech.app.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepo;

    public ProductoServiceImpl(ProductoRepository productoRepo) {
        this.productoRepo = productoRepo;
    }

    @Override
    public Producto crear(Producto producto) {
        return productoRepo.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return productoRepo.findAll();
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        return productoRepo.findById(id);
    }

    @Override
    public Producto actualizar(Integer id, Producto producto) {
        Producto existente = productoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existente.setDescripcion(producto.getDescripcion());
        existente.setImagen(producto.getImagen());
        existente.setPrecio(producto.getPrecio());

        return productoRepo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        productoRepo.deleteById(id);
    }
}
