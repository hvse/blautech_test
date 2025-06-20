package com.blautech.app.service;

import com.blautech.app.entity.Carrito;
import com.blautech.app.repository.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepo;

    public CarritoServiceImpl(CarritoRepository carritoRepo) {
        this.carritoRepo = carritoRepo;
    }

    @Override
    public Carrito crear(Carrito carrito) {
        return carritoRepo.save(carrito);
    }

    @Override
    public List<Carrito> listar() {
        return carritoRepo.findAll();
    }

    @Override
    public Optional<Carrito> buscarPorId(Integer id) {
        return carritoRepo.findById(id);
    }

    @Override
    public Carrito actualizar(Integer id, Carrito carrito) {
        Carrito existente = carritoRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        existente.setIdCarrito(carrito.getIdCarrito());
        existente.setIdProducto(carrito.getIdProducto());
        existente.setIdUsuario(carrito.getIdUsuario());
        existente.setPrecio(carrito.getPrecio());
        existente.setCantidad(carrito.getCantidad());
        existente.setFecha(carrito.getFecha());

        return carritoRepo.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        carritoRepo.deleteById(id);
    }
}
