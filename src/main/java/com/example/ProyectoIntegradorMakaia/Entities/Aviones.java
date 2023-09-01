package com.example.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "aviones")
public class Aviones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_avion;

    @Column(nullable = false)
    private String modelo_avion;

    @Column(nullable = false)
    private int capacidad_pasajeros;

    @Column(nullable = false)
    private Date anio_fabricacion;

}