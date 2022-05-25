package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Domain.StatinfEntity;
import com.Psuti.StudentManager.Service.StatinfService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class StatinfController {

    private StatinfService statinfService;

    @GetMapping("/statinf")
    public String viewSubjectPage(Model model) {
        List<StatinfEntity> statinfEntities = statinfService.listAll();
        model.addAttribute("stateinfList", statinfEntities);
        return "Statinf/statinf";
    }

    @GetMapping("/statinf/newStatInf")
    public String add(Model model) {
        List<StatinfEntity> statinfEntities = statinfService.listAll();
        model.addAttribute("statementList", statinfEntities);
        model.addAttribute("statinf", new StatinfEntity());
        return "Statinf/newStatInf";
    }

    @RequestMapping(value = "statinf/save", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute("stateinf") StatinfEntity statinf) {
        statinfService.save(statinf);
        return "redirect:/statinf";
    }

    @RequestMapping("/stateinf/edit/{id}")
    public ModelAndView showEditSubjectPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("Statinf/newStatInf");
        StatinfEntity statinfEntity = statinfService.get(id);
        mav.addObject("statinf", statinfEntity);
        return mav;
    }

    @RequestMapping("/statinf/delete/{id}")
    public String deleteSubjectPage(@PathVariable(name = "id") int id) {
        statinfService.delete(id);
        return "redirect:/statinf";
    }
}
