package com.burak.studentmanagement.service;

import com.burak.studentmanagement.entity.Professeur;

import java.util.List;

public interface ProfesseurService {
    Professeur save(Professeur professeur);
    Professeur findById(Long id);
    List<Professeur> findAll();
    void deleteById(Long id);
}