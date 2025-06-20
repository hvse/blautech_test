package com.blautech.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "carrito")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_carrito")
    private Integer idCarrito;

    @Column(name = "id_producto")
    private Integer idProducto;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    private BigDecimal precio;

    private Integer cantidad;

    private LocalDateTime fecha;
}
