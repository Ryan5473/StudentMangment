package com.burak.studentmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "etudiant")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "groupe_id")
    private Groupe groupe;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Note> notes;

    @ManyToMany
    @JoinTable(
        name = "student_role",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    // Getters, Setters, Constructors
}