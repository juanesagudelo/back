package com.example.back.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "facultades")
public class Facultad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String decano;

    @Column(nullable = false)
    private String ubicacion;

    @JsonIgnore
    @OneToMany(mappedBy = "facultad", cascade = CascadeType.ALL)
    private List<ProgramaAcademico> programas;
}