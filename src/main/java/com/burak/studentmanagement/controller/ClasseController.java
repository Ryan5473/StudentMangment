package com.burak.studentmanagement.controller;

import com.burak.studentmanagement.dao.ClasseRepository;
import com.burak.studentmanagement.entity.Classe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController  {

    @Autowired
    private ClasseService classeService;

    @GetMapping
    public String listClasses(Model model) {
        model.addAttribute("classes", classeService.findAll());
        return "classes_list";
    }

    @GetMapping("/create")
    public String createClasseForm(Model model) {
        model.addAttribute("classe", new Classe());
        return "create_class";
    }

    @PostMapping("/create")
    public String createClasse(@ModelAttribute Classe classe) {
        classeService.save(classe);
        return "redirect:/classes";
    }

    @GetMapping("/edit/{id}")
    public String editClasseForm(@PathVariable Long id, Model model) {
        model.addAttribute("classe", classeService.findById(id));
        return "edit_class";
    }

    @PostMapping("/edit/{id}")
    public String updateClasse(@PathVariable Long id, @ModelAttribute Classe classe) {
        classe.setId(id);
        classeService.save(classe);
        return "redirect:/classes";
    }

    @GetMapping("/{id}")
    public String viewClasse(@PathVariable Long id, Model model) {
        model.addAttribute("classe", classeService.findById(id));
        return "class_detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteClasse(@PathVariable Long id) {
        classeService.deleteById(id);
        return "redirect:/classes";
    }
}