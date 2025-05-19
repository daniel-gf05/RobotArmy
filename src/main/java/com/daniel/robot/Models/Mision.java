package com.daniel.robot.Models;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "misiones")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mision {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private String dificultad; // baja | media | alta
    private int recompensa;
    private List<String> robotsParticipantes;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String resultado; // pendiente | éxito | fracaso
}