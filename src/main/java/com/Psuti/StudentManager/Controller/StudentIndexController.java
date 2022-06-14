package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Domain.*;
import com.Psuti.StudentManager.Service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class StudentIndexController {

    private StatementService statementService;
    private StatinfService statinfService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String indexStudent() {
        return "Student/home";
    }

    @RequestMapping("/statement")
    public String viewStatementPage(Model model) {
        List<StatementEntity> statementEntities = statementService.listAll();
        model.addAttribute("statementList", statementEntities);
        return "Student/statement";
    }

    @RequestMapping("/statinf")
    public String viewStatInfPage(Model model) {
        List<StatinfEntity> statinfEntities = statinfService.listAll();
        model.addAttribute("statinfList", statinfEntities);
        return "Student/statinf";
    }
}
