package com.proyecto.controller;

import com.proyecto.domain.AcercaDe;
import com.proyecto.service.AcercaDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AcercaDeController {

    @Autowired
    private AcercaDeService acercaDeService;
    
    @GetMapping("/acercaDe/listado")
    public String inicio(Model model) {
        var acercaDes = acercaDeService.getAcercaDes(false);
        model.addAttribute("acercaDes", acercaDes);
        return "/acercaDe/listado";
    }

    @PostMapping("/acercaDe/guardar")
    public String guardarAcercaDe(AcercaDe acercaDe) {
        acercaDeService.save(acercaDe);
        return "redirect:/acercaDe/listado";
    }

    @GetMapping("/acercaDe/modificar/{idAcercaDe}")
    public String modificarAcercaDe(AcercaDe acercaDe, Model model) {
        acercaDe = acercaDeService.getAcercaDe(acercaDe);
        model.addAttribute("acercaDe", acercaDe);
        return "/acercaDe/modificar";
    }

    @GetMapping("/acercaDe/eliminar/{idAcercaDe}")
    public String eliminarAcercaDe(AcercaDe acercaDe) {
        acercaDeService.delete(acercaDe);
        return "/acercaDe/listado";
    }
}

