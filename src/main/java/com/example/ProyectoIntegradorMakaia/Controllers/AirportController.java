package com.example.ProyectoIntegradorMakaia.Controllers;

import com.example.ProyectoIntegradorMakaia.Entities.Aeropuerto;
import com.example.ProyectoIntegradorMakaia.Services.AeropuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private final AeropuertoService aeropuertoService;

    @Autowired
    public AirportController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    // Endpoint para obtener todos los aeropuertos
    @GetMapping
    public ResponseEntity<List<Aeropuerto>> gettAllAirpots() {
        List<Aeropuerto> aeropuertos = aeropuertoService.getAllAirports();
        return new ResponseEntity<>(aeropuertos, HttpStatus.OK);
    }

    // Obtener aeropuerto por id. Si se encuentra status ok de lo contrario not found
    @GetMapping("/{id}")
    public ResponseEntity<Aeropuerto> getAirportById(@PathVariable Long id) {
        Aeropuerto aeropuerto = aeropuertoService.getAirportById(id);

        if (aeropuerto != null) {
            return new ResponseEntity<>(aeropuerto, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para crear un aeropuerto
    @PostMapping
    public ResponseEntity<Aeropuerto> createAirport(@RequestBody Aeropuerto airport) {
        Aeropuerto newAirport = aeropuertoService.createAirport(airport);
        return new ResponseEntity<>(newAirport, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un aeropuerto por su id
    @PutMapping("/{id}")
    public ResponseEntity<Aeropuerto> updateAirport(@PathVariable Long id, @RequestBody Aeropuerto updateAirport) {
        Aeropuerto airport = aeropuertoService.updateAirport(id, updateAirport);

        if (airport != null) {
            return new ResponseEntity<>(airport, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint para eliminar un aeropuerto por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Aeropuerto> deleteAirport(@PathVariable Long id) {
        aeropuertoService.deleteAirport(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}