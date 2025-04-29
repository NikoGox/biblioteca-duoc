package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class LibroRepository {

    private List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> obtenerListaLibros() {
        return listaLibros;

    }

    public Libro buscarPorId(int id){
        for (Libro libro : listaLibros) {
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for (Libro libro : listaLibros) {
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public Libro guardar(Libro libro){
        listaLibros.add(libro);
        return libro;
    }

    public Libro actualizar(Libro lib){
        int id =0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()){
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libroNuevo = new Libro();
        libroNuevo.setId(id);
        libroNuevo.setIsbn(lib.getIsbn());
        libroNuevo.setTitulo(lib.getTitulo());
        libroNuevo.setAutor(lib.getAutor());
        libroNuevo.setEditorial(lib.getEditorial());

        listaLibros.set(idPosicion, libroNuevo);
        return libroNuevo;

    }

    public void eliminar(int id){
        Libro libro = buscarPorId(id);
        listaLibros.remove(libro);
    }



}
