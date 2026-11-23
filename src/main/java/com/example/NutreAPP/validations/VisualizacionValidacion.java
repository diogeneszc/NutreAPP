package com.example.NutreAPP.validations;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VisualizacionValidacion {

    // V1. La fecha de visualizacion es obligatoria.                     -> 400
    public void validarFecha (LocalDate fecha){
        if (fecha==null) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La fecha de visualizacion es obligatorio");  
        }
    }
    // V2. La fecha NO puede ser futura (nadie ve un video manana).      -> 400
    //     Pista: fecha.isAfter(LocalDate.now())
    public void validarFechaActual (LocalDate fecha){
        if (fecha.isAfter(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La fecha de la visualizacion debe ser actual");
        }
    }
    // V3. El campo completado es obligatorio (true o false, no null).   -> 400
    //
    // V4. El usuario y el video deben EXISTIR en la BD.                 -> 404
    //     Pista: inyectar IUsuarioRepositorio e IVideoRepositorio y
    //     usar existsById(id)
    

    
    
}
