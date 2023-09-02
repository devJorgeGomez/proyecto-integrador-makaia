package com.example.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vuelo;
 
    @ManyToOne
    @JoinColumn(name = "aeropuertoOrigen_id", nullable = false)
    private Aeropuerto aeropuertoOrigen;

    @ManyToOne
    @JoinColumn(name = "aeropuertoDestino_id", nullable = false)
    private Aeropuerto aeropuertoDestino;

    @Column(nullable = false)
    private Date fecha_hora_salida;

    @Column(nullable = false)
    private Date fecha_hora_llegada;

    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    private Avion avion;

    @ManyToMany(mappedBy = "vuelos")
    private Set<Reserva> reservas = new HashSet<>();

}