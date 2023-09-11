package com.ProyectoIntegradorMakaia.Repositories;

import com.ProyectoIntegradorMakaia.Entities.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Cliente, Long> {}