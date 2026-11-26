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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.services.UsuarioServicio;
import com.example.NutreAPP.services.VideoServicio;
import com.example.NutreAPP.services.VisualizacionServicio;

@RestController
@RequestMapping("/api/v1/visualizaciones")
public class VisualizacionControlador {

    @Autowired
    private VisualizacionServicio servicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private VideoServicio videoServicio;

    // Usuario y video no se leen del body (tienen @JsonBackReference),
    // por eso llegan por la URL y se cargan desde la BD.
    @PostMapping("/usuario/{usuarioId}/video/{videoId}")
    public ResponseEntity<Visualizacion> guardar(@PathVariable UUID usuarioId,@PathVariable UUID videoId,@RequestBody Visualizacion datos) {
        Usuario usuario = this.usuarioServicio.buscarPorId(usuarioId);
        Video video = this.videoServicio.buscarPorId(videoId);
        datos.setUsuario(usuario);
        datos.setVideo(video);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.servicio.guardarVisualizacion(datos, usuario));
    }

    @GetMapping
    public ResponseEntity<List<Visualizacion>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicio.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Visualizacion> buscarPorId(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicio.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> eliminar(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.servicio.eliminarVisualizacion(id));
    }
}