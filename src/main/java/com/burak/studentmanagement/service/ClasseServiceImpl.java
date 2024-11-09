package com.burak.studentmanagement.service;

import com.burak.studentmanagement.dao.ClasseDao;
import com.burak.studentmanagement.entity.Classe;
import com.burak.studentmanagement.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseDao classeDao;

    @Override
    public Classe save(Classe classe) {
        return classeDao.save(classe);
    }

    @Override
    public Classe findById(Long id) {
        return classeDao.findById(id);
    }

    @Override
    public List<Classe> findAll() {
        return classeDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        classeDao.deleteById(id);
    }
}