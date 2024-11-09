package com.burak.studentmanagement.dao;
import com.burak.studentmanagement.entity.Professeur;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProfesseurDaoImpl implements ProfesseurRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Professeur professeur) {
        entityManager.persist(professeur);
    }

    @Override
    public Professeur findById(Long id) {
        return entityManager.find(Professeur.class, id);
    }

    @Override
    public List<Professeur> findAll() {
        String query = "SELECT p FROM Professeur p";
        return entityManager.createQuery(query, Professeur.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Professeur professeur = findById(id);
        if (professeur != null) {
            entityManager.remove(professeur);
        }
    }
}