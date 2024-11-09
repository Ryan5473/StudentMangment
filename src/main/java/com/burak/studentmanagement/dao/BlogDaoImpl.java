package com.burak.studentmanagement.dao;
import com.burak.studentmanagement.entity.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogDaoImpl implements BlogDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public Blog findById(Long id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public List<Blog> findByClasseId(Long classeId) {
        String query = "SELECT b FROM Blog b WHERE b.classe.id = :classeId";
        return entityManager.createQuery(query, Blog.class)
                            .setParameter("classeId", classeId)
                            .getResultList();
    }

    @Override
    public List<Blog> findAll() {
        String query = "SELECT b FROM Blog b";
        return entityManager.createQuery(query, Blog.class).getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }
}