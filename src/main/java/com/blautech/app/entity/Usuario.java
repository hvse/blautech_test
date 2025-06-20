package com.blautech.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;

    @Column(name = "direccion_envio")
    private String direccionEnvio;

    private String email;

    @Column(name = "fecha_nac")
    private LocalDate fechaNacimiento;

    private String password;

}
