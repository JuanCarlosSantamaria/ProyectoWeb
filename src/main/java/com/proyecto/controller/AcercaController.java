package com.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AcercaController {

    
    @GetMapping("/nosotros")
    public String inicio(Model model) {
        return "/nosotros";
    }

}

