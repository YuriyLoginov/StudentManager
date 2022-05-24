package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class TeacherController {

    private TeacherService teacherService;

}
