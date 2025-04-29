package com.example.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Prestamo {
    private int id_prestamo;
    private int id_libro;
    private String run_solicitante;
    private int fechaSolicitud;
    private int fechaPublicacion;
    private int cantidadDias;
    private int multas = 0;
}
