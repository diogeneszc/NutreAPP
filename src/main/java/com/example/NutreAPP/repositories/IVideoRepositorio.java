package com.example.NutreAPP.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.helpers.Categoria;

@Repository 
public interface IVideoRepositorio  extends JpaRepository {
   
    // Buscar videos por categoría
    List<Video> findByCategoria(Categoria categoria);

    // Buscar videos por título (ignora mayúsculas/minúsculas)
    List<Video> findByTituloIgnoreCase(String titulo);

    // Buscar videos por descripción (contiene fragmentos del texto)
    List<Video> findByDescripcionContainingIgnoreCase(String descripcion);

    // Buscar videos por título y categoría
    List<Video> findByTituloIgnoreCaseAndCategoria(String titulo, Categoria categoria);

    // Buscar videos por URL
    Optional<Video> findByUrl(String url);
   
}
