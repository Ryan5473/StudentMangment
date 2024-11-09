package com.burak.studentmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
    private List<Student> students;

    // Getters, Setters, Constructors
}
