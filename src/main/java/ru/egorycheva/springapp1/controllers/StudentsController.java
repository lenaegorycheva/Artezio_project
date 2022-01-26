package ru.egorycheva.springapp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.egorycheva.springapp1.dao.StudentDAO;
import ru.egorycheva.springapp1.models.Student;
import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentsController {
    private final StudentDAO studentDAO;

    public StudentsController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping()
    public String getStudents(Model model){
        model.addAttribute("students", studentDAO.getStudents());
        return "students/getStudents";
    }

    @GetMapping("/{id}")
    public String showStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("student", studentDAO.showStudent(id));
        return "students/showStudent";
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model){
        model.addAttribute("groups", studentDAO.getGroups());
        model.addAttribute("student",new Student());
        return "students/newStudent";
    }

    @PostMapping()
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()) {
            model.addAttribute("groups", studentDAO.getGroups());
            return "students/newStudent";
        }
        studentDAO.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/editStudent")
    public String editStudents(@PathVariable("id") int id, Model model){
        model.addAttribute("groups", studentDAO.getGroups());
        model.addAttribute("student", studentDAO.showStudent(id));
        return "/students/editStudent";
    }

    @PatchMapping("/{id}")
    public String updateStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult, @PathVariable("id") int id, Model model){
        if (bindingResult.hasErrors()) {
            model.addAttribute("groups", studentDAO.getGroups());
            return "/students/editStudent";
        }
        studentDAO.updateStudent(id, student);
        return "redirect:/students";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentDAO.deleteStudent(id);
        return "redirect:/students";
    }

}
