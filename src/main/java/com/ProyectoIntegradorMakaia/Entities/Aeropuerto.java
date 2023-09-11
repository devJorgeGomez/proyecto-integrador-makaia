package com.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aeropuerto;

    @Column(nullable = false)
    private String nombre_aeropuerto;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String pais;

    @Column(nullable = false)
    private String codigo_iata_oaci;

    @OneToMany(mappedBy = "aeropuertoOrigen", cascade = CascadeType.ALL)
    private Set<Vuelo> vuelosOrigen;

    @OneToMany(mappedBy = "aeropuertoDestino")
    private List<Vuelo> vuelosDestino;

}