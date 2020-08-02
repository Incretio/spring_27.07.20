package ru.geekbrains.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ru.geekbrains.sample.dto.Student;
import ru.geekbrains.sample.repository.StudentsRepository;

@Controller
public class MainController {

    private StudentsRepository studentsRepository;

    public MainController(@Autowired StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping("/")
    public String getIndexPage() {
      return "index";
   }

    @GetMapping("/students")
    public String getStudentPage(Model model) {
        model.addAttribute("students", studentsRepository.findAll());
        return "students";
    }

    @GetMapping("/profile/{id}")
    public String getStudentPage(Model model, @PathVariable long id) {
        model.addAttribute("student", studentsRepository.findById(id));
        return "profile";
    }

    @PostMapping("/students")
    public String sendForm(@ModelAttribute Student student) {
        System.out.println(student);
        return "redirect:/";
    }

}