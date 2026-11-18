package com.example.NutreAPP.services;

import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;

@Service
public class VideoServicio {
    private IVideoRepositorio repositorio;
    
    public Video guarVideo(Video datos){
        return this.repositorio.save(datos);
    }

}
