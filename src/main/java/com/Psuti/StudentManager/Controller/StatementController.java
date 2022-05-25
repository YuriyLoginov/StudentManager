package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Domain.StatementEntity;
import com.Psuti.StudentManager.Service.StatementService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class StatementController {

    private StatementService statementService;

    @GetMapping("/statement")
    public String viewSubjectPage(Model model) {
        List<StatementEntity> statementEntities = statementService.listAll();
        model.addAttribute("statementList", statementEntities);
        return "Statement/Statement";
    }

    @GetMapping("/statement/newStatement")
    public String add(Model model) {
        List<StatementEntity> statementEntities = statementService.listAll();
        model.addAttribute("statementList", statementEntities);
        model.addAttribute("statement", new StatementEntity());
        return "Statement/newStatement";
    }

    @RequestMapping(value = "statement/save", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute("statement") StatementEntity statement) {
        statementService.save(statement);
        return "redirect:/statement";
    }

    @RequestMapping("/statement/edit/{id}")
    public ModelAndView showEditSubjectPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("Statement/newStatement");
        StatementEntity statementEntity = statementService.get(id);
        mav.addObject("statement", statementEntity);
        return mav;
    }

    @RequestMapping("/statement/delete/{id}")
    public String deleteSubjectPage(@PathVariable(name = "id") int id) {
        statementService.delete(id);
        return "redirect:/statement";
    }
}
