package com.Psuti.StudentManager.Controller;

import com.Psuti.StudentManager.Repository.StudentRepo;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@Data
public class StudentController {

    private StudentRepo studentRepo;

}
