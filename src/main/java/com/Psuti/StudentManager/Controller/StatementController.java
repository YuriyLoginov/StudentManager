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
@RequestMapping("/statement")
public class StatementController {

    private StatementService statementService;



    @GetMapping("/newStatement")
    public String add(Model model) {
        List<StatementEntity> statementEntities = statementService.listAll();
        model.addAttribute("statementList", statementEntities);
        model.addAttribute("statement", new StatementEntity());
        return "Statement/newStatement";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStatement(@ModelAttribute("statement") StatementEntity statement) {
        statementService.save(statement);
        return "redirect:/statement";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStatementPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("Statement/newStatement");
        StatementEntity statementEntity = statementService.get(id);
        mav.addObject("statement", statementEntity);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStatementPage(@PathVariable(name = "id") int id) {
        statementService.delete(id);
        return "redirect:/statement";
    }
}
