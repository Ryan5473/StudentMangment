package com.burak.studentmanagement.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prenom", nullable = false)
    private String prenom;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "expediteur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messagesEnvoyes;

    @OneToMany(mappedBy = "destinataire", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Message> messagesRecus;

    public User() {}

    public User(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    // Getters and Setters
}