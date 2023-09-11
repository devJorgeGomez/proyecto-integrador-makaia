package com.ProyectoIntegradorMakaia.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "info_contacto")
public class Info_contacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_info;

    @OneToMany(mappedBy = "info_contacto")
    private List<Cliente> clientes = new ArrayList<>();

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String numero_telefono;

    @Column(nullable = false)
    private String direccion;

}