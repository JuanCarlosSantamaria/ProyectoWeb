
package com.proyecto.controller;

import com.proyecto.service.AutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    private AutoService autoService;

    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora utilizamos MVC");
        
      
        var autos = autoService.getAutos(true);
    
        model.addAttribute("autos", autos);
        
  
        return "index";
    }

}
