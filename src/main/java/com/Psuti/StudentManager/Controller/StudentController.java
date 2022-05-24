package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Repository.StudentRepo;
import com.Psuti.StudentManager.Service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;


@Controller
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

}
