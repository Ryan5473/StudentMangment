package com.burak.studentmanagement.service;

import com.burak.studentmanagement.dao.ProfesseurDao;
import com.burak.studentmanagement.entity.Professeur;
import com.burak.studentmanagement.service.ProfesseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    @Autowired
    private ProfesseurDao professeurDao;

    @Override
    public Professeur save(Professeur professeur) {
        return professeurDao.save(professeur);
    }

    @Override
    public Professeur findById(Long id) {
        return professeurDao.findById(id);
    }

    @Override
    public List<Professeur> findAll() {
        return professeurDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        professeurDao.deleteById(id);
    }
}