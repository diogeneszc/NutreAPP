package com.example.NutreAPP.models;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table (name = "visualizaciones")
public class Visualizacion {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    @Column (name = "fecha_visualizacion", nullable = false, unique = false)
    private LocalDate fechaVisualizacion;
    @Column (name = "completar", nullable = false, unique = false)
    private Boolean completar;
    
    @ManyToOne
    @JoinColumn (name = "usuario_id", nullable = false)
    @JsonBackReference (value = "usuario-visualizacion")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn (name = "video_id", nullable = false)
    @JsonBackReference (value = "video-visualizacion")
    private Video video;

    public Visualizacion() {
    }
     public Visualizacion(UUID id, LocalDate fechaVisualizacion, Boolean completar) {
        this.id = id;
        this.fechaVisualizacion = fechaVisualizacion;
        this.completar = completar;
     }
     public UUID getId() {
         return id;
     }
     public void setId(UUID id) {
         this.id = id;
     }
     public LocalDate getFechaVisualizacion() {
    return fechaVisualizacion;
    }
    public void setFechaVisualizacion(LocalDate fechaVisualizacion) {
        this.fechaVisualizacion = fechaVisualizacion;
    }
     public Boolean getCompletar() {
         return completar;
     }
     public void setCompletar(Boolean completar) {
         this.completar = completar;
     }

     public Usuario getUsuario() { return usuario; }
     public void setUsuario(Usuario usuario) { this.usuario = usuario; }

     public Video getVideo() { return video; }

     public void setVideo(Video video) { this.video = video; }

     

}
