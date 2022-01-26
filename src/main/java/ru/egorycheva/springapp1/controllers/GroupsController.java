package ru.egorycheva.springapp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.egorycheva.springapp1.dao.GroupDAO;
import ru.egorycheva.springapp1.models.AcademicGroup;
import ru.egorycheva.springapp1.models.Student;

import javax.validation.Valid;

@Controller
@RequestMapping("/groups")
public class GroupsController {
    private final GroupDAO groupDAO;

    public GroupsController(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @GetMapping()
    public String getGroups(Model model){
        model.addAttribute("groups", groupDAO.getGroups());
        return "groups/getGroups";
    }

    @GetMapping("/{id}")
    public String showGroup(@PathVariable("id") int id, Model model){
        model.addAttribute("group", groupDAO.showGroup(id));
        return "groups/showGroup";
    }

    @GetMapping("/newGroup")
    public String newStudent(Model model){
        model.addAttribute("group",new AcademicGroup());
        return "groups/newGroup";
    }

    @PostMapping()
    public String createStudent(@Valid @ModelAttribute("group") AcademicGroup group, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            return "groups/newGroup";
        }
        groupDAO.saveGroup(group);
        return "redirect:/groups";
    }

    @GetMapping("/{id}/editGroup")
    public String editGroups(@PathVariable("id") int id, Model model){
        model.addAttribute("group", groupDAO.showGroup(id));
        return "/groups/editGroup";
    }

    @PatchMapping("/{id}")
    public String updateGroup(@ModelAttribute("group") @Valid AcademicGroup group, BindingResult bindingResult, @PathVariable("id") int id, Model model){
        if (bindingResult.hasErrors()) {
            return "/groups/editGroup";
        }
        groupDAO.updateGroup(id, group);
        return "redirect:/groups";
    }

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable("id") int id){
        groupDAO.deleteGroup(id);
        return "redirect:/groups";
    }
}
