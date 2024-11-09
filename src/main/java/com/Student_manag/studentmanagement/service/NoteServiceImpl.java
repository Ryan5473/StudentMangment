package com.burak.studentmanagement.service;

import com.burak.studentmanagement.dao.NoteRepository;
import com.burak.studentmanagement.entity.Note;
import com.burak.studentmanagement.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao noteDao;

    @Override
    public Note save(Note note) {
        return noteDao.save(note);
    }

    @Override
    public Note findById(Long id) {
        return noteDao.findById(id);
    }

    @Override
    public List<Note> findAll() {
        return noteDao.findAll();
    }

    @Override
    public void deleteById(Long id) {
        noteDao.deleteById(id);
    }
}