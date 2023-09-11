package com.ProyectoIntegradorMakaia.Models.Services;

import com.ProyectoIntegradorMakaia.Repositories.RepositorioAvion;
import com.ProyectoIntegradorMakaia.Entities.Avion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AircraftService {

    private final RepositorioAvion repository;

    @Autowired
    public AircraftService(RepositorioAvion aircraft) {
        this.repository = aircraft;
    }

    public List<Avion> getAllAircrafts() {
        return (List<Avion>) repository.findAll();
    }

    public Avion getAircraftById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Avion createAircraft(Avion aircraft) {
        return this.repository.save(aircraft);
    }

    public void deleteAircraft(Long id) {
        this.repository.deleteById(id);
    }

    public Avion updateAircraft(Long id, Avion updateAircraft) {

        Avion existingAircraft = repository.findById(id).orElse(null);

        if (existingAircraft != null) {
            existingAircraft.setModelo_avion(updateAircraft.getModelo_avion());
            existingAircraft.setCapacidad_pasajeros(updateAircraft.getCapacidad_pasajeros());
            existingAircraft.setAnio_fabricacion(updateAircraft.getAnio_fabricacion());
            return repository.save(existingAircraft);
        }

        return null;

    }

}