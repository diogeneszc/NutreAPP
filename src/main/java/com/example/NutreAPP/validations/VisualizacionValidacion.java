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
   

    
    
}
