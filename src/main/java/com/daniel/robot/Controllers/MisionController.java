package com.daniel.robot.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.robot.Models.Mision;
import com.daniel.robot.Services.MisionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/misiones")
@RequiredArgsConstructor
public class MisionController {

    private final MisionService misionService;

    @PostMapping
    public Mision crearMision(@RequestBody Mision mision) {
        return misionService.crearMision(mision);
    }

    @GetMapping
    public List<Mision> listarMisiones() {
        return misionService.listarMisiones();
    }

    @PatchMapping("/{id}/asignar-robot")
    public Mision asignarRobot(@PathVariable String id, @RequestBody String robotId) {
        // Elimina las comillas adicionales si existen
        robotId = robotId.replace("\"", "");
        return misionService.asignarRobot(id, robotId);

    }

}
