package com.burak.studentmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classe")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Groupe> groupes;

    @ManyToMany
    @JoinTable(
        name = "classe_matiere",
        joinColumns = @JoinColumn(name = "classe_id"),
        inverseJoinColumns = @JoinColumn(name = "matiere_id")
    )
    private List<Matiere> matieres;

    // Getters, Setters, Constructors
}