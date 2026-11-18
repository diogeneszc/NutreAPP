package com.example.NutreAPP.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public Usuario buscarPorId(UUID id){
        Optional<Usuario>usuarioBuscado = this.repositorio.findById(id);

        if (!usuarioBuscado.isPresent()){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "id no encontrado");

        } else{
            return usuarioBuscado.get();
        }
    }
    // metodo para buscar por todos
    public List<Usuario> buscarTodos(){
        return this.repositorio.findAll();

    }
    // metodo para modificar
    // metdo para eliminar

    //metodo para buscar por departamento y rol
    //metodo para buscar por correo
    // metodo para buscar por rol
    //metodo para verificar correo
}
