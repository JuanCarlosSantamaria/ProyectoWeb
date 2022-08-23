package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class FormController {

    
    @GetMapping("/form")
    public String inicio(Model model) {
        return "/form";
    }

}
