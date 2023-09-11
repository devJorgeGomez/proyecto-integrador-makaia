package com.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_reserva;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "reserva_vuelo",
            joinColumns = @JoinColumn(name = "reserva_id"),
            inverseJoinColumns = @JoinColumn(name = "vuelo_id"))
    private Set<Vuelo> vuelos = new HashSet<>();

    @Column(nullable = false)
    private Date fecha_hora_reserva;

    @OneToOne
    @JoinColumn(name = "id_estado_reserva", nullable = false)
    private Estados_reserva estado_reserva;

}