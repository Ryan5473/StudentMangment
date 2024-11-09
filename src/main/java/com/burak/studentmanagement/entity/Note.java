package com.burak.studentmanagement.entity;

import javax.persistence.*;

@Entity
@Table(name = "note")
public class Note{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valeur;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    // Getters, Setters, Constructors
}