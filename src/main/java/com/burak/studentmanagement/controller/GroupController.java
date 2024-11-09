package com.burak.studentmanagement.controller;

import com.burak.studentmanagement.entity.Groupe;
import com.burak.studentmanagement.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping
    public String listGroups(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "groups_list";
    }

    @GetMapping("/create")
    public String createGroupForm(Model model) {
        model.addAttribute("group", new Group());
        return "create_group";
    }

    @PostMapping("/create")
    public String createGroup(@ModelAttribute Group group) {
        groupService.save(group);
        return "redirect:/groups";
    }

    @GetMapping("/edit/{id}")
    public String editGroupForm(@PathVariable Long id, Model model) {
        model.addAttribute("group", groupService.findById(id));
        return "edit_group";
    }

    @PostMapping("/edit/{id}")
    public String updateGroup(@PathVariable Long id, @ModelAttribute Group group) {
        group.setId(id);
        groupService.save(group);
        return "redirect:/groups";
    }

    @GetMapping("/{id}")
    public String viewGroup(@PathVariable Long id, Model model) {
        model.addAttribute("group", groupService.findById(id));
        return "group_detail";
    }

    @GetMapping("/delete/{id}")
    public String deleteGroup(@PathVariable Long id) {
        groupService.deleteById(id);
        return "redirect:/groups";
    }
}