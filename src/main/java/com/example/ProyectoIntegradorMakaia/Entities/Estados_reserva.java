package com.example.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "estado_reserva")
public class Estados_reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado;

    @Column(nullable = false)
    private String nombre_estado;

}