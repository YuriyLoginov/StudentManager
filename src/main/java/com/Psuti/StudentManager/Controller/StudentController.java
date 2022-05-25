package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Domain.StudentEntity;
import com.Psuti.StudentManager.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @GetMapping("/student")
    public String viewSubjectPage(Model model) {
        List<StudentEntity> studentEntities = studentService.listAll();
        model.addAttribute("studentList", studentEntities);
        return "Student/student";
    }

    @GetMapping("/student/newStudent")
    public String add(Model model) {
        List<StudentEntity> studentEntities = studentService.listAll();
        model.addAttribute("studentList", studentEntities);
        model.addAttribute("student", new StudentEntity());
        return "Student/newStudent";
    }

    @RequestMapping(value = "student/save", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute("student") StudentEntity student) {
        studentService.save(student);
        return "redirect:/student";
    }

    @RequestMapping("/student/edit/{id}")
    public ModelAndView showEditSubjectPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("Student/newStudent");
        StudentEntity studentEntity = studentService.get(id);
        mav.addObject("student", studentEntity);
        return mav;
    }

    @RequestMapping("/student/delete/{id}")
    public String deleteSubjectPage(@PathVariable(name = "id") int id) {
        studentService.delete(id);
        return "redirect:/student";
    }
}