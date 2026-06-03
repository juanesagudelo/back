package com.example.back.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "programas_academicos")
public class ProgramaAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nivel;

    @Column(nullable = false)
    private Integer duracionSemestres;

    @ManyToOne
    @JoinColumn(name = "facultad_id", nullable = false)
    private Facultad facultad;
}