package com.proyecto.controller;

import com.proyecto.domain.Cabana;
import com.proyecto.service.CabanaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CabanaController {

    @Autowired
    private CabanaService cabanaService;

    @GetMapping("/cabana/listado")
    public String inicio(Model model) {
        var cabanas = cabanaService.getCabanas(false);
        model.addAttribute("cabanas", cabanas);
        return "/cabana/listado";
    }

    @GetMapping("/cabana/nuevo")
    public String nuevoCabana(Cabana cabana, Model model) {
        var cabanas = cabanaService.getCabanas(false);
        model.addAttribute("cabanas", cabanas);
        return "/cabana/modificar";
    }

    @PostMapping("/cabana/guardar")
    public String guardarCabana(Cabana cabana) {
        cabanaService.save(cabana);
        return "redirect:/cabana/listado";
    }

    @GetMapping("/cabana/modificar/{idCabana}")
    public String modificarCabana(Cabana cabana, Model model) {
        cabana = cabanaService.getCabana(cabana);
        model.addAttribute("cabana", cabana);
        return "/cabana/modificar";
    }

    @GetMapping("/cabana/eliminar/{idCabana}")
    public String eliminarCabana(Cabana cabana) {
        cabanaService.delete(cabana);
        return "/cabana/listado";

    }
}
