package com.Psuti.StudentManager.Controller;


import com.Psuti.StudentManager.Domain.*;
import com.Psuti.StudentManager.Service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class IndexController {

    private GroupService groupService;
    private StatementService statementService;
    private StatinfService statinfService;
    private SubjectService subjectService;
    private TeacherService teacherService;
    private StudentService studentService;


    @RequestMapping(value = "/teacher/home", method = RequestMethod.GET)
    public String indexTeacher() {
        return "Teacher/home";
    }

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public String viewGroupPage(Model model) {
        List<StudentGroupEntity> groupEntities = groupService.listAll();
        model.addAttribute("groupList", groupEntities);
        return "Group/group";
    }

    @RequestMapping("/statement")
    public String viewStatementPage(Model model) {
        List<StatementEntity> statementEntities = statementService.listAll();
        model.addAttribute("statementList", statementEntities);
        return "Statement/Statement";
    }

    @RequestMapping("/statinf")
    public String viewStatInfPage(Model model) {
        List<StatinfEntity> statinfEntities = statinfService.listAll();
        model.addAttribute("statinfList", statinfEntities);
        return "Statinf/statinf";
    }

    @RequestMapping("/student")
    public String viewStudentPage(Model model) {
        List<StudentEntity> studentEntities = studentService.listAll();
        model.addAttribute("studentList", studentEntities);
        return "Student/student";
    }

    @GetMapping("/subject")
    public String viewSubjectPage(Model model) {
        List<SubjectEntity> subjectEntities = subjectService.listAll();
        model.addAttribute("subjectList", subjectEntities);
        return "Subject/subject";
    }

    @RequestMapping("/teacher")
    public String viewTeacherPage(Model model) {
        List<TeacherEntity> teacherEntities = teacherService.listAll();
        model.addAttribute("teacherList", teacherEntities);
        return "Teacher/teacher";
    }

}
