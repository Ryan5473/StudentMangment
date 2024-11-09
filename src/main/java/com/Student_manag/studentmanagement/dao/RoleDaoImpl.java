package com.burak.studentmanagement.dao;

import com.burak.studentmanagement.entity.Role;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public Role findById(int id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public Role findByName(String name) {
        String query = "SELECT r FROM Role r WHERE r.name = :name";
        return entityManager.createQuery(query, Role.class)
                            .setParameter("name", name)
                            .getSingleResult();
    }

    @Override
    public List<Role> findAll() {
        String query = "SELECT r FROM Role r";
        return entityManager.createQuery(query, Role.class).getResultList();
    }

    @Override
    public void deleteById(int id) {
        Role role = findById(id);
        if (role != null) {
            entityManager.remove(role);
        }
    }