package com.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private Date fecha_nacimiento;

    @Column(nullable = false)
    private char genero;

    @ManyToOne
    @JoinColumn(name = "info_contacto_id", referencedColumnName = "id_info", nullable = false)
    private Info_contacto info_contacto;

}