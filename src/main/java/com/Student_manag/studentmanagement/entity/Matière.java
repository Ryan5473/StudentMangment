package com.burak.studentmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Matière {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "matieres")
    private List<Classe> classes;

    // Getters, Setters, Constructors
}
