package com.burak.studentmanagement.service;

import com.burak.studentmanagement.dao.EtudiantDao;
import com.burak.studentmanagement.entity.Etudiant;
import com.burak.studentmanagement.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantDao etudiantDao;

    @Override
    public Etudiant save(Etudiant etudiant) {
        return etudiantDao.save(etudiant);
    }

    @Override
    public Etudiant findById(Long id) {
        return etudiantDao.findById(id);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        etudiantDao.deleteById(id);
    }
}
