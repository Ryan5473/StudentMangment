package com.burak.studentmanagement.dao;
import com.burak.studentmanagement.entity.Note;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NoteDaoImpl  implements NoteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Note note) {
        entityManager.persist(note);
    }

    @Override
    public Note findById(Long id) {
        return entityManager.find(Note.class, id);
    }

    @Override
    public List<Note> findByEtudiantId(Long etudiantId) {
        String query = "SELECT n FROM Note n WHERE n.etudiant.id = :etudiantId";
        return entityManager.createQuery(query, Note.class)
                            .setParameter("etudiantId", etudiantId)
                            .getResultList();
    }

    @Override
    public List<Note> findAll() {
        String query = "SELECT n FROM Note n";
        return entityManager.createQuery(query, Note.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Note note = findById(id);
        if (note != null) {
            entityManager.remove(note);
        }
    }
}