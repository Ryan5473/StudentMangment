package com.burak.studentmanagement.service;

import com.burak.studentmanagement.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog save(Blog blog);
    Blog findById(Long id);
    List<Blog> findAll();
    void deleteById(Long id);
}