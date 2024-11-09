package com.burak.studentmanagement.controller;

import com.burak.studentmanagement.entity.Matiere;
import com.burak.studentmanagement.service.MatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/matieres")
public class MatiereController {

    @Autowired
    private MatiereService matiereService;

    @GetMapping
    public String listMatieres(Model model) {
        model.addAttribute("matieres", matiereService.findAll());
        return "matieres_list";
    }

    @GetMapping("/create")
    public String createMatiereForm(Model model) {
        model.addAttribute("matiere", new Matiere());
        return "create_matiere";
    }

    @PostMapping("/create")
    public String createMatiere(@ModelAttribute Matiere matiere) {
        matiereService.save(matiere);
        return "redirect:/matieres";
    }

    @GetMapping("/edit/{id}")
    public String editMatiereForm(@PathVariable Long id, Model model) {
        model.addAttribute("matiere", matiereService.findById(id));
        return "edit_matiere";
    }

    @PostMapping("/edit/{id}")
    public String updateMatiere(@PathVariable Long id, @ModelAttribute Matiere matiere) {
        matiere.setId(id);
        matiereService.save(matiere);
        return "redirect:/matieres";
    }

    @GetMapping("/{id}")
    public String viewMatiere(@PathVariable Long id, Model model) {
        model.addAttribute("matiere", matiereService.findById(id));
        return "matiere_detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteMatiere(@PathVariable Long id) {
        matiereService.deleteById(id);
        return "redirect:/matieres";
    }
}