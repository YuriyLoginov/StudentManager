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
@RequestMapping("/statinf")
public class StatinfController {

    private StatinfService statinfService;



    @GetMapping("/newStatInf")
    public String add(Model model) {
        List<StatinfEntity> statinfEntities = statinfService.listAll();
        model.addAttribute("statinfList", statinfEntities);
        model.addAttribute("statinf", new StatinfEntity());
        return "Statinf/newStatInf";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStatInf(@ModelAttribute("statinf") StatinfEntity statinf) {
        statinfService.save(statinf);
        return "redirect:/statinf";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStatInfPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("Statinf/newStatInf");
        StatinfEntity statinfEntity = statinfService.get(id);
        mav.addObject("statinf", statinfEntity);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteStatInfPage(@PathVariable(name = "id") int id) {
        statinfService.delete(id);
        return "redirect:/statinf";
    }
}
