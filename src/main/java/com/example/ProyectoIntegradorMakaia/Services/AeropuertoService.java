package com.example.ProyectoIntegradorMakaia.Services;

import com.example.ProyectoIntegradorMakaia.Entities.Aeropuerto;
import com.example.ProyectoIntegradorMakaia.Repositories.AeropuertoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeropuertoService {

    private final AeropuertoRepositorio aeropuertoRepositorio;

    @Autowired
    public AeropuertoService(AeropuertoRepositorio aeropuertoRepositorio) {
        this.aeropuertoRepositorio = aeropuertoRepositorio;
    }

    public List<Aeropuerto> getAllAirports() {
        return (List<Aeropuerto>) aeropuertoRepositorio.findAll();
    }

    public Aeropuerto getAirportById(Long id) {
        return aeropuertoRepositorio.findById(id).orElse(null);
    }

    public Aeropuerto createAirport(Aeropuerto aeropuerto) {
        return this.aeropuertoRepositorio.save(aeropuerto);
    }

    public Aeropuerto updateAirport(Long id, Aeropuerto updateAirport) {
        Aeropuerto existingAirport = aeropuertoRepositorio.findById(id).orElse(null);

        if (existingAirport != null) {
            existingAirport.setNombre_aeropuerto(updateAirport.getNombre_aeropuerto());
            existingAirport.setCodigo_iata_oaci(updateAirport.getCodigo_iata_oaci());
            existingAirport.setCiudad(updateAirport.getCiudad());
            existingAirport.setPais(updateAirport.getPais());
            return aeropuertoRepositorio.save(existingAirport);
        }

        return null;
    }

    public void deleteAirport(Long id) {
        this.aeropuertoRepositorio.deleteById(id);
    }

}