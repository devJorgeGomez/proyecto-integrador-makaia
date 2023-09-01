package com.example.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "estados_reserva")
public class Estados_reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_estado;

    @Column(nullable = false)
    private String nombre_estado;

}