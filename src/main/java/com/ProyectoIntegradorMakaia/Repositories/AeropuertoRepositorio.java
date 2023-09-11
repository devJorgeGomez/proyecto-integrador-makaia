package com.ProyectoIntegradorMakaia.Repositories;

import com.ProyectoIntegradorMakaia.Entities.Aeropuerto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertoRepositorio extends CrudRepository<Aeropuerto, Long> {}