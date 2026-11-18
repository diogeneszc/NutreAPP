package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.repositories.IUsuarioRepositorio;

@Service
public class UsuarioServicio {
    // Para programar los servicios necesito los repositorios 
    // INYECCION DE DEPENDENCIAS
    @Autowired
    private IUsuarioRepositorio repositorio;

    //metodo guardar
    public Usuario guardUsuario(Usuario datos){
        return this.repositorio.save(datos);
    }
    // metodo buscar por id
    // metodo para buscar por todos
    // metodo para modificar
    // metdo para eliminar

    //metodo para buscar por departamento y rol
    //metodo para buscar por correo
    // metodo para buscar por rol
    //metodo para verificar correo
}
