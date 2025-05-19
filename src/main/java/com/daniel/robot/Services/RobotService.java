package com.daniel.robot.Services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daniel.robot.Models.Robot;
import com.daniel.robot.Repositories.RobotRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RobotService {

    private final RobotRepository robotRepo;

    public Robot crear(Robot robot) {
        robot.setEnergiaActual(robot.getEnergiaMaxima());
        return robotRepo.save(robot);
    }

    public List<Robot> listar() {
        return robotRepo.findAll();
    }

    public Robot recargar(String id) {
        Robot robot = robotRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        robot.setEnergiaActual(robot.getEnergiaMaxima());
        return robotRepo.save(robot);
    }

    public Robot subirNivel(String id) {
        Robot robot = robotRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        robot.setNivel(robot.getNivel() + 1);
        return robotRepo.save(robot);
    }
}
