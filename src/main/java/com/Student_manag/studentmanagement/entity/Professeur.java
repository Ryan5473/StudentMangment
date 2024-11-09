package com.burak.studentmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "professeur")
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "professeur", cascade = CascadeType.ALL)
    private List<Blog> blogs;

    @ManyToMany
    @JoinTable(
        name = "professeur_matiere",
        joinColumns = @JoinColumn(name = "professeur_id"),
        inverseJoinColumns = @JoinColumn(name = "matiere_id")
    )
    private List<Matiere> matieres;

    @ManyToMany
    @JoinTable(
        name = "professeur_role",
        joinColumns = @JoinColumn(name = "professeur_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    // Getters, Setters, Constructors
}