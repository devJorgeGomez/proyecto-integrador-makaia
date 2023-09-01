package com.example.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "aeropuertos")
public class Aeropuertos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_aeropuerto;

    @Column(nullable = false)
    private String nombre_aeropuerto;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String codigo_iata_oaci;

}