package com.daniel.robot.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daniel.robot.Models.Mision;
import com.daniel.robot.Models.Robot;
import com.daniel.robot.Repositories.MisionRepository;
import com.daniel.robot.Repositories.RobotRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MisionService {

    private final MisionRepository misionRepo;
    private final RobotRepository robotRepo;

    public Mision crearMision(Mision mision) {
        // Inicializa lista si es null para evitar errores
        if (mision.getRobotsParticipantes() == null) {
            mision.setRobotsParticipantes(new ArrayList<>());
        }
        return misionRepo.save(mision);
    }

    public List<Mision> listarMisiones() {
        return misionRepo.findAll();
    }

    public Mision asignarRobot(String idMision, String idRobot) {
        Mision mision = misionRepo.findById(idMision)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Misión no encontrada"));
        Robot robot = robotRepo.findById(idRobot)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Robot no encontrado"));

        if (!mision.getRobotsParticipantes().contains(idRobot)) {
            mision.getRobotsParticipantes().add(idRobot);
            misionRepo.save(mision);
        }

        if (!robot.getMisionesRealizadas().contains(idMision)) {
            robot.getMisionesRealizadas().add(idMision);
            robotRepo.save(robot);
        }

        return mision;
    }
}
