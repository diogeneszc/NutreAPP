package com.example.NutreAPP.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.services.VideoServicio;

@RestController
@RequestMapping("/api/v1/videos")
public class VideoControlador {

    @Autowired
    private VideoServicio servicio;

    @PostMapping
    public ResponseEntity<Video> guardar(@RequestBody Video datos) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.servicio.guarVideo(datos));
    }

    @GetMapping
    public ResponseEntity<List<Video>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicio.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicio.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Video> modificar(@PathVariable UUID id, @RequestBody Video datos) {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicio.modificarVideo(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicio.eliminarVideo(id));
    }
}