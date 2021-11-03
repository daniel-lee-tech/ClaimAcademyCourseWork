package com.claim.controllers;

import com.claim.entity.Address;
import com.claim.entity.Student;
import com.claim.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String welcome(Model model) {
        return "welcome";
    }

//    @GetMapping("/signup")
//    public ModelAndView signup(Model model) {
//        return new ModelAndView("signup", "student", new Student())
//    }


    @GetMapping("/signup")
    public String signup(Model model) {
        Address address = new Address();
        Student student = new Student();
        student.setAddress(address);
        model.addAttribute("student", student);
        return "signup";
    }

    @PostMapping("/signup")
    public String postSign(@ModelAttribute("student") Student student, Model model, HttpSession session) {
        model.addAttribute("newStudent", student);
        studentService.saveStudent(student);
        return "thankyou";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("newLogin", new Student());
        return "login";
    }

    @PostMapping("login")
    public String checkLogin(@ModelAttribute("newLogin") Student student, Model model, RedirectAttributes redirectAttributes) {

        boolean validCredentials = studentService.authenticate(student);

        if (validCredentials) {
            model.addAttribute("allStudents", studentService.getStudents());
            return "home";
        } else {
            model.addAttribute("badCredentials", true);
            return "login";
        }
    }

    @GetMapping("/home")
    public String showHome(Model model) {
        model.addAttribute("allStudents", studentService.getStudents());
        return "home";
    }
}
