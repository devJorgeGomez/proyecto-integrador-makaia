package com.ProyectoIntegradorMakaia.Models;

import com.ProyectoIntegradorMakaia.Utils.AuthorityName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "authorities")
public class Authority {

    public Authority(AuthorityName authorityName) {
        this. name = authorityName;
    }

    public Authority() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthorityName name;

}
