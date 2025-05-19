package com.daniel.robot.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daniel.robot.Models.Mision;
import com.daniel.robot.Services.MisionService;

@Controller
public class MisionWebController {

    @Autowired
    private MisionService misionService;

    @GetMapping("/misiones-vista")
    public String listarMisiones(Model model) {
        List<Mision> misiones = misionService.listarMisiones();
        System.out.println("Misiones recuperadas: " + (misiones != null ? misiones.size() : "null"));
        model.addAttribute("misiones", misiones);
        return "misiones";
    }
}