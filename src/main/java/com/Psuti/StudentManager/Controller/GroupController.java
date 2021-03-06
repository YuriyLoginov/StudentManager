package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Domain.StudentGroupEntity;
import com.Psuti.StudentManager.Service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private GroupService groupService;

    @GetMapping("/group")
    public String viewGroupPage(Model model) {
        List<StudentGroupEntity> groupEntities = groupService.listAll();
        model.addAttribute("groupList", groupEntities);
        return "Group/group";
    }

    @GetMapping("/newGroup")
    public String add(Model model) {
        List<StudentGroupEntity> groupEntities = groupService.listAll();
        model.addAttribute("groupList", groupEntities);
        model.addAttribute("group", new StudentGroupEntity());
        return "Group/newGroup";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveGroup(@ModelAttribute("group") StudentGroupEntity group) {
        groupService.save(group);
        return "redirect:/group";
    }

    @RequestMapping("/group/edit/{id}")
    public ModelAndView showEditGroupPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("Group/newGroup");
        StudentGroupEntity groupEntity = groupService.get(id);
        mav.addObject("group", groupEntity);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteGroupPage(@PathVariable(name = "id") int id) {
        groupService.delete(id);
        return "redirect:/group";
    }
}
