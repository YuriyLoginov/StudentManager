package com.Psuti.StudentManager.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class AuthenticationController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
