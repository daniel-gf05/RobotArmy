package com.daniel.robot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.robot.Models.Robot;
import com.daniel.robot.Services.RobotService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/robots")
@RequiredArgsConstructor
public class RobotController {

    private final RobotService robotService;

    @PostMapping
    public Robot crear(@RequestBody Robot robot) {
        return robotService.crear(robot);
    }

    @GetMapping
    public List<Robot> listar() {
        return robotService.listar();
    }

    @PatchMapping("/{id}/recargar")
    public Robot recargar(@PathVariable String id) {
        return robotService.recargar(id);
    }

    @PatchMapping("/{id}/subir-nivel")
    public Robot subirNivel(@PathVariable String id) {
        return robotService.subirNivel(id);
    }
}
