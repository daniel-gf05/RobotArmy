package com.daniel.robot.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daniel.robot.Repositories.MisionRepository;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class VistaMisionController {

    private final MisionRepository misionRepo;

    @GetMapping("/misiones/view")
    public String verMisiones(Model model) {
        model.addAttribute("misiones", misionRepo.findAll());
        return "misiones";
    }
}
