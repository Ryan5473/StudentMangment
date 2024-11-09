package com.burak.studentmanagement.service;

import com.burak.studentmanagement.entity.Classe;

import java.util.List;

public interface ClasseService {
    Classe save(Classe classe);
    Classe findById(Long id);
    List<Classe> findAll();
    void deleteById(Long id);
}
