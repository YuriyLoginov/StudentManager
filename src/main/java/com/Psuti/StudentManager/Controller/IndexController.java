package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.DAO.StudentDAO;
import com.Psuti.StudentManager.Domain.*;
import com.Psuti.StudentManager.Repository.StudentRepo;
import com.Psuti.StudentManager.Service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
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
    private StudentRepo studentRepo;


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

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String viewStudentPage(Model model) {
        List<StudentDAO> list = new ArrayList<>();
        for (Object[] o : studentRepo.findStudent()) {
            StudentDAO student = new StudentDAO();
            student.setId(Long.parseLong(String.valueOf(o[0])));
            student.setCourse((String) o [1]);
            student.setDateOfBirth((String) o [2]);
            student.setFirstName((String) o[3]);
            student.setLastName((String) o [4]);
            student.setLogin((String) o [5]);
            student.setPassword((String) o [6]);
            student.setPatronymic((String) o [7]);
            student.setGroupId((String) o [8]);
            student.setRole((String) o [9]);
            list.add(student);
        }
        model.addAttribute("liststudent",list);
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
