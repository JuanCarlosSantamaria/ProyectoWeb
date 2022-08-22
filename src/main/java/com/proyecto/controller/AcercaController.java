package com.proyecto.controller;

import com.proyecto.domain.Acerca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.proyecto.service.AcercaService;

@Controller
public class AcercaController {

    @Autowired
    private AcercaService acercaService;
    
    @GetMapping("/acerca/listado")
    public String inicio(Model model) {
        var acercas = acercaService.getAcercas(false);
        model.addAttribute("acercas", acercas);
        return "/acerca/listado";
    }

    @PostMapping("/acerca/guardar")
    public String guardarAcerca(Acerca acerca) {
        acercaService.save(acerca);
        return "redirect:/acerca/listado";
    }

    @GetMapping("/acerca/modificar/{idAcerca}")
    public String modificarAcerca(Acerca acerca, Model model) {
        acerca = acercaService.getAcerca(acerca);
        model.addAttribute("acerca", acerca);
        return "/acerca/modificar";
    }

    @GetMapping("/acerca/eliminar/{idAcerca}")
    public String eliminarAcerca(Acerca acerca) {
        acercaService.delete(acerca);
        return "redirect:/acerca/listado";
    }
}

