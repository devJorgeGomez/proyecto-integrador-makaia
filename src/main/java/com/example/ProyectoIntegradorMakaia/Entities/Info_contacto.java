package com.example.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "info_contacto")
public class Info_contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_info;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int numero_telefono;

    @Column(nullable = false)
    private String direccion;

}