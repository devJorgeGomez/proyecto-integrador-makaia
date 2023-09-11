package com.ProyectoIntegradorMakaia.Repositories;

import com.ProyectoIntegradorMakaia.Entities.Avion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioAvion extends CrudRepository<Avion, Long> {}