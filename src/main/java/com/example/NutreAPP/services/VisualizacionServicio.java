package com.example.NutreAPP.services;

import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Service
public class VisualizacionServicio {

    private IVisualizacionRepositorio repositorio;

    public Visualizacion guardarVisualizacion(Visualizacion datos){
        return this.repositorio.save(datos);
    }

}
