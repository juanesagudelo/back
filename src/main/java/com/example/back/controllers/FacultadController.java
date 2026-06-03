package com.example.back.controllers;

import com.example.back.entities.Facultad;
import com.example.back.services.FacultadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/facultades")
public class FacultadController {

    private final FacultadService facultadService;

    public FacultadController(FacultadService facultadService) {
        this.facultadService = facultadService;
    }

    @GetMapping
    public ResponseEntity<List<Facultad>> listar() {
        return ResponseEntity.ok(facultadService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Facultad> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(facultadService.obtener(id));
    }

    @PostMapping
    public ResponseEntity<Facultad> crear(@RequestBody Facultad facultad) {
        return ResponseEntity.ok(facultadService.crear(facultad));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Facultad> actualizar(@PathVariable Long id, @RequestBody Facultad facultad) {
        return ResponseEntity.ok(facultadService.actualizar(id, facultad));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facultadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}