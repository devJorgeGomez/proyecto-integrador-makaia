package com.example.ProyectoIntegradorMakaia.Services;

import com.example.ProyectoIntegradorMakaia.Entities.Aeropuerto;
import com.example.ProyectoIntegradorMakaia.Repositories.AeropuertoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoService {

    private final AeropuertoRepositorio repositorio;

    @Autowired
    public AeropuertoService(AeropuertoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public List<Aeropuerto> getAllAirports() {
        return (List<Aeropuerto>) repositorio.findAll();
    }

    public Aeropuerto getAirportById(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Aeropuerto createAirport(Aeropuerto aeropuerto) {
        return this.repositorio.save(aeropuerto);
    }

    public void deleteAirport(Long id) {
        this.repositorio.deleteById(id);
    }

    public Aeropuerto updateAirport(Long id, Aeropuerto updateAirport) {

        Aeropuerto existingAirport = repositorio.findById(id).orElse(null);

        if (existingAirport != null) {
            existingAirport.setNombre_aeropuerto(updateAirport.getNombre_aeropuerto());
            existingAirport.setCodigo_iata_oaci(updateAirport.getCodigo_iata_oaci());
            existingAirport.setCiudad(updateAirport.getCiudad());
            existingAirport.setPais(updateAirport.getPais());
            return repositorio.save(existingAirport);
        }

        return null;

    }

}