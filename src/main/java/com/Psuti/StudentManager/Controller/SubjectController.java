package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Domain.SubjectEntity;
import com.Psuti.StudentManager.Repository.SubjectRepo;
import com.Psuti.StudentManager.Service.SubjectService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Data
public class SubjectController {

    private final SubjectService service;


    @GetMapping("/subject")
    public String viewSubjectPage(Model model) {
        List<SubjectEntity> subjectEntities = service.listAll();
        model.addAttribute("subjectList", subjectEntities);
        return "Subject/subject";
    }

    @GetMapping("/subject/new")
    public String add(Model model) {
        List<SubjectEntity> subjectEntities = service.listAll();
        model.addAttribute("subjectList", subjectEntities);
        model.addAttribute("subjectList", new SubjectEntity());
        return "Subject/newSubject";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveSubject(@ModelAttribute("subject") SubjectEntity subject) {
        service.save(subject);
        return "redirect:/subject";
    }

    @RequestMapping("/subject/eddit/{id}")
    public ModelAndView showEditSubjectPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("Subject/newSubject");
        SubjectEntity subjectEntity = service.get(id);
        mav.addObject("subject", subjectEntity);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteSubjectPage(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/subject";
    }
}
