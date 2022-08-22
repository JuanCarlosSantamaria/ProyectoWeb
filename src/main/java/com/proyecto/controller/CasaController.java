package com.proyecto.controller;

import com.proyecto.domain.Casa;
import com.proyecto.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CasaController {

    @Autowired
    private CasaService casaService;

    @GetMapping("/casa/listado")
    public String inicio(Model model) {
        var casas = casaService.getCasas(false);
        model.addAttribute("casas", casas);
        return "/casa/listado";
    }

    @GetMapping("/casa/nuevo")
    public String nuevoCasa(Casa casa, Model model) {
        var casas = casaService.getCasas(false);
        model.addAttribute("casas", casas);
        return "/casa/modificar";
    }

    @PostMapping("/casa/guardar")
    public String guardarCasa(Casa casa) {
        casaService.save(casa);
        return "redirect:/casa/listado";
    }

    @GetMapping("/casa/modificar/{idCasa}")
    public String modificarCasa(Casa casa, Model model) {
        casa = casaService.getCasa(casa);
        model.addAttribute("casa", casa);
        return "/casa/modificar";
    }

    @GetMapping("/casa/eliminar/{idCasa}")
    public String eliminarCasa(Casa casa) {
        casaService.delete(casa);
        return "redirect:/casa/listado";

    }
}
