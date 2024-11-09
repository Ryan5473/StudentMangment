package com.burak.studentmanagement.dao;
import com.burak.studentmanagement.entity.Classe;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClasseDaoImpl implements ClasseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Classe classe) {
        entityManager.persist(classe);
    }

    @Override
    public Classe findById(Long id) {
        return entityManager.find(Classe.class, id);
    }

    @Override
    public List<Classe> findAll() {
        String query = "SELECT c FROM Classe c";
        return entityManager.createQuery(query, Classe.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Classe classe = findById(id);
        if (classe != null) {
            entityManager.remove(classe);
        }
    }
}