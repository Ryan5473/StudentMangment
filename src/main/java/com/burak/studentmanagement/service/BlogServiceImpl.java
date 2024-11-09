package com.burak.studentmanagement.service;

import com.burak.studentmanagement.dao.BlogDao;
import com.burak.studentmanagement.entity.Blog;
import com.burak.studentmanagement.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    public Blog save(Blog blog) {
        return blogDao.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogDao.findById(id);
    }

    @Override
    public List<Blog> findAll() {
        return blogDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        blogDao.deleteById(id);
    }
}