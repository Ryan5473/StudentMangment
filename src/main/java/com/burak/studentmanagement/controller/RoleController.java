package com.burak.studentmanagement.controller;

import com.burak.studentmanagement.dao.RoleRepository;
import com.burak.studentmanagement.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    @Autowired
    private RoleDao roleDao;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        roleDao.save(role);
        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable int id) {
        Role role = roleDao.findById(id);
        return role != null ? new ResponseEntity<>(role, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Role> getAllRoles() {
        return roleDao.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id) {
        roleDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}