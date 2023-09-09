package com.example.ProyectoIntegradorMakaia.Controllers;

import com.example.ProyectoIntegradorMakaia.Entities.Avion;
import com.example.ProyectoIntegradorMakaia.Services.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aircraft")
public class AircraftController {

    private final AircraftService aircraftService;

    @Autowired
    public AircraftController(AircraftService aircraftService) {
        this.aircraftService = aircraftService;
    }

    @GetMapping
    public ResponseEntity<List<Avion>> getAllAircraft() {
        List<Avion> aircrafts = aircraftService.getAllAircrafts();
        return new ResponseEntity<>(aircrafts, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Avion> getAircraftById(@PathVariable Long id) {
        Avion aircraft = aircraftService.getAircraftById(id);

        if (aircraft != null) {
            return new ResponseEntity<>(aircraft, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Avion> createAircraft(@RequestBody Avion aircraft) {
        Avion newAircraft = aircraftService.createAircraft(aircraft);
        return new ResponseEntity<>(newAircraft, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avion> updateAircraft(@PathVariable Long id, @RequestBody Avion updateAircraft) {
        Avion aircraft = aircraftService.updateAircraft(id, updateAircraft);

        if (aircraft != null) {
            return new ResponseEntity<>(aircraft, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Avion> deleteAircraft(@PathVariable Long id) {
        aircraftService.deleteAircraft(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}