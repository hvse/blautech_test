package com.blautech.app.controller;

import com.blautech.app.entity.Carrito;
import com.blautech.app.service.CarritoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
@CrossOrigin(origins = "*")
public class CarritoController {

    private final CarritoService service;

    public CarritoController(CarritoService service) {
        this.service = service;
    }

    @Operation(
            summary = "Crear un pedido",
            description = "Crear un pedido"
    )
    @PostMapping
    public ResponseEntity<Carrito> crear(@RequestBody Carrito carrito) {
        return ResponseEntity.ok(service.crear(carrito));
    }

    @Operation(
            summary = "listar pedidos",
            description = "listar pedidos"
    )
    @GetMapping
    public ResponseEntity<List<Carrito>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @Operation(
            summary = "listar pedidos por id",
            description = "listar pedidos por id"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Carrito> buscar(@PathVariable Integer id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(
            summary = "Actualizar pedidos por id",
            description = "Actualizar pedidos por id"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizar(@PathVariable Integer id, @RequestBody Carrito carrito) {
        return ResponseEntity.ok(service.actualizar(id, carrito));
    }

    @Operation(
            summary = "Borrar pedidos por id",
            description = "Borrar pedidos por id"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
