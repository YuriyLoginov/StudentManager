package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Domain.TeacherEntity;
import com.Psuti.StudentManager.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class TeacherController {

    private TeacherService teacherService;

    @GetMapping("/teacher")
    public String viewSubjectPage(Model model) {
        List<TeacherEntity> teacherEntities = teacherService.listAll();
        model.addAttribute("teacherList", teacherEntities);
        return "Teacher/teacher";
    }

    @GetMapping("/teacher/newTeacher")
    public String add(Model model) {
        List<TeacherEntity> teacherEntities = teacherService.listAll();
        model.addAttribute("teacherList", teacherEntities);
        model.addAttribute("teacher", new TeacherEntity());
        return "Teacher/newTeacher";
    }

    @RequestMapping(value = "teacher/save", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute("teacher") TeacherEntity teacher) {
        teacherService.save(teacher);
        return "redirect:/teacher";
    }

    @RequestMapping("/teacher/edit/{id}")
    public ModelAndView showEditSubjectPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("Teacher/newTeacher");
        TeacherEntity teacher = teacherService.get(id);
        mav.addObject("teacher", teacher);
        return mav;
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteSubjectPage(@PathVariable(name = "id") int id) {
        teacherService.delete(id);
        return "redirect:/teacher";
    }
}
