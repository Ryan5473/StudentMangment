package com.burak.studentmanagement.service;

import com.burak.studentmanagement.entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant save(Etudiant etudiant);
    Etudiant findById(Long id);
    List<Etudiant> findAll();
    void deleteById(Long id);
}