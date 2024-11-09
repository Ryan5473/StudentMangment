package com.burak.studentmanagement.service;

import com.burak.studentmanagement.entity.Note;

import java.util.List;

public interface NoteService {
    Note save(Note note);
    Note findById(Long id);
    List<Note> findAll();
    void deleteById(Long id);
}