package com.example.back.services;

import com.example.back.entities.Facultad;
import com.example.back.repositories.FacultadRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacultadService {

    private final FacultadRepository facultadRepository;

    public FacultadService(FacultadRepository facultadRepository) {
        this.facultadRepository = facultadRepository;
    }

    public List<Facultad> listar() {
        return facultadRepository.findAll();
    }

    public Facultad obtener(Long id) {
        return facultadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada"));
    }

    public Facultad crear(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    public Facultad actualizar(Long id, Facultad facultad) {
        Facultad f = facultadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Facultad no encontrada"));
        f.setNombre(facultad.getNombre());
        f.setDecano(facultad.getDecano());
        f.setUbicacion(facultad.getUbicacion());
        return facultadRepository.save(f);
    }

    public void eliminar(Long id) {
        facultadRepository.deleteById(id);
    }
}