package com.example.NutreAPP.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.NutreAPP.models.Visualizacion;

@Repository 
public interface IVisualizacionRepositorio extends JpaRepository <Visualizacion, UUID> {


    // Buscar visualizaciones por fecha de visualización
    List<Visualizacion> findByFechaVisualizacion(LocalDate fechaVisualizacion);

    // Buscar visualizaciones sin completar
    List<Visualizacion> findByCompletadoFalse();

    // Buscar visualizaciones completadas
    List<Visualizacion> findByCompletadoTrue();
}
