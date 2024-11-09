package com.burak.studentmanagement.dao;

import com.burak.studentmanagement.entity.Etudiant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EtudiantDaoImpl implements EtudiantRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Etudiant etudiant) {
        entityManager.persist(etudiant);
    }

    @Override
    public Etudiant findById(Long id) {
        return entityManager.find(Etudiant.class, id);
    }

    @Override
    public List<Etudiant> findByClasseId(Long classeId) {
        String query = "SELECT e FROM Etudiant e WHERE e.classe.id = :classeId";
        return entityManager.createQuery(query, Etudiant.class)
                            .setParameter("classeId", classeId)
                            .getResultList();
    }

    @Override
    public List<Etudiant> findAll() {
        String query = "SELECT e FROM Etudiant e";
        return entityManager.createQuery(query, Etudiant.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Etudiant etudiant = findById(id);
        if (etudiant != null) {
            entityManager.remove(etudiant);
        }
    }
}