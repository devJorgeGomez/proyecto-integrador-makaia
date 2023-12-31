package com.ProyectoIntegradorMakaia.Repositories;

import com.ProyectoIntegradorMakaia.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Metodo para retornar un usuario por su nombre
    Optional<User> findByUsername(String username);
}