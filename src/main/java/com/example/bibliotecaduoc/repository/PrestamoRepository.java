package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Prestamo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Repository
public class PrestamoRepository {

    private List<Prestamo> listaPrestamos = new ArrayList<>();

    public List<Prestamo> obtenerListaPrestamos() {
        return listaPrestamos;

    }

    public Prestamo buscarPorIdPrestamo(int id_prestamo) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId_prestamo() == id_prestamo) {
                return prestamo;
            }
        }
        return null;
    }

    public Prestamo buscarPorIdLibro(int id_libro) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getId_libro() == (id_libro)) {
                return prestamo;
            }
        }
        return null;
    }

    public Prestamo guardar(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
        return prestamo;
    }

    public Prestamo actualizar(Prestamo prestamo) {
        int id_prestamo = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getId_prestamo() == prestamo.getId_prestamo()) {
                id_prestamo = prestamo.getId_prestamo();
                idPosicion = i;
            }
        }

        Prestamo prestamoNuevo = new Prestamo();
        prestamoNuevo.setId_prestamo(id_prestamo);
        prestamoNuevo.setId_libro(prestamo.getId_libro());
        prestamoNuevo.setRun_solicitante(prestamo.getRun_solicitante());
        prestamoNuevo.setFechaSolicitud(prestamo.getFechaSolicitud());
        prestamoNuevo.setCantidadDias(prestamo.getCantidadDias());
        prestamoNuevo.setMultas(prestamo.getMultas());

        listaPrestamos.set(idPosicion, prestamoNuevo);
        return prestamoNuevo;

    }

    public void eliminar(int id) {
        Prestamo prestamo = buscarPorIdPrestamo(id);
        listaPrestamos.remove(prestamo);
    }
}
