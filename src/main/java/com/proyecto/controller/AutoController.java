package com.proyecto.controller;

import com.proyecto.domain.Auto;
import com.proyecto.service.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AutoController {

    @Autowired
    private AutoService autoService;
    
    @GetMapping("/auto/listado")
    public String inicio(Model model) {
        var autos = autoService.getAutos(false);
        model.addAttribute("autos", autos);
        return "/auto/listado";
    }

    @GetMapping("/auto/nuevo")
    public String nuevoAuto(Auto auto, Model model) {
        var autos = autoService.getAutos(false);
        model.addAttribute("autos", autos);
        return "/auto/modificar";
    }

    @PostMapping("/auto/guardar")
    public String guardarAuto(Auto auto) {
        autoService.save(auto);
        return "redirect:/auto/listado";
    }

    @GetMapping("/auto/modificar/{idAuto}")
    public String modificarAuto(Auto auto, Model model) {
        auto = autoService.getAuto(auto);
        model.addAttribute("auto", auto);
        return "/auto/modificar";
    }

    @GetMapping("/auto/eliminar/{idAuto}")
    public String eliminarAuto(Auto auto) {
        autoService.delete(auto);
        return "/auto/listado";
    }
}

