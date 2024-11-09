package com.burak.studentmanagement.service;

import com.burak.studentmanagement.dao.RoleDao;
import com.burak.studentmanagement.entity.Role;
import com.burak.studentmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role findById(int id) {
        return roleDao.findById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void deleteById(int id) {
        roleDao.deleteById(id);
    }
}