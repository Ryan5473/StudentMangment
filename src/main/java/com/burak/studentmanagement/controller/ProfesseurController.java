package com.burak.studentmanagement.controller;

import com.burak.studentmanagement.dao.ProfesseurRepository;
import com.burak.studentmanagement.entity.Professeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professeurs")
public class ProfesseurController {

    @Autowired
    private ProfesseurService professeurService;

    @GetMapping
    public String listProfessors(Model model) {
        model.addAttribute("professors", professeurService.findAll());
        return "professors_list";
    }

    @GetMapping("/create")
    public String createProfessorForm(Model model) {
        model.addAttribute("professor", new Professeur());
        return "create_professor";
    }

    @PostMapping("/create")
    public String createProfessor(@ModelAttribute Professeur professor) {
        professeurService.save(professor);
        return "redirect:/professors";
    }

    @GetMapping("/edit/{id}")
    public String editProfessorForm(@PathVariable Long id, Model model) {
        model.addAttribute("professor", professeurService.findById(id));
        return "edit_professor";
    }

    @PostMapping("/edit/{id}")
    public String updateProfessor(@PathVariable Long id, @ModelAttribute Professeur professor) {
        professor.setId(id);
        professeurService.save(professor);
        return "redirect:/professors";
    }

    @GetMapping("/{id}")
    public String viewProfessor(@PathVariable Long id, Model model) {
        model.addAttribute("professor", professeurService.findById(id));
        return "professor_detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professeurService.deleteById(id);
        return "redirect:/professors";
    }
}