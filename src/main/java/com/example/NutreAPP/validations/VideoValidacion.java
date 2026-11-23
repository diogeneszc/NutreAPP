package com.example.NutreAPP.validations;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class VideoValidacion {
    
    // V1. Titulo obligatorio y entre 5 y 120 caracteres.               -> 400
    
    public void validarTitulo (String valor, String campo){
        if (valor == null || valor.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El campo " + campo +" es obligatorio");
        }
        if (valor.trim().length()<5 || valor.trim().length()>120) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El " + campo +" debe tener entre 5 y 120 caracteres");
        }
    }
   

}
