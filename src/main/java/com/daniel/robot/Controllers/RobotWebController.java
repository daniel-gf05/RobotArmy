package com.daniel.robot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.daniel.robot.Services.RobotService;

@Controller
public class RobotWebController {

    @Autowired
    private RobotService robotService;

    @GetMapping("/robots-vista")
    public String listarRobots(Model model) {
        model.addAttribute("robots", robotService.listar());
        return "robots"; // Se refiere a templates/robots.html
    }
}
