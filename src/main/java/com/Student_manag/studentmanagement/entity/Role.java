package com.burak.studentmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany(mappedBy = "roles")
    private List<Student> students;

    @ManyToMany(mappedBy = "roles")
    private List<Professeur> professeurs;

    // Getters, Setters, Constructors
}