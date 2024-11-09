package com.burak.studentmanagement.service;

import com.burak.studentmanagement.entity.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role);
    Role findById(int id);
    List<Role> findAll();
    void deleteById(int id);
}