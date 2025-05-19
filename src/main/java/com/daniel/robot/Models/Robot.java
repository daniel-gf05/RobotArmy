package com.daniel.robot.Models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "robots")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Robot {
    @Id
    private String id;
    private String nombre;
    private String modelo;
    private String tipo;
    private int energiaActual;
    private int energiaMaxima;
    private int nivel;
    private List<String> habilidades;
    private String estado; // activo | dañado | destruido
    private List<String> misionesRealizadas;
}
