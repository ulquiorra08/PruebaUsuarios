package com.prueba.demo.services;

import com.prueba.demo.models.Responses;
import com.prueba.demo.models.UsuarioModel;
import com.prueba.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModel> getObtenerUsuarios(){
        return (ArrayList<UsuarioModel>) usuarioRepository.findAll();
    }

    public UsuarioModel guardarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public Responses eliminarUsuario(Long id){
        Responses responses = new Responses();
        Long cont = usuarioRepository.count();
        try {
            usuarioRepository.deleteById(id);
        }catch (Exception ex){
            responses.setCodigo("01");
            responses.setMensajeError("No se pudo eliminar el usuario por: "+ex.getMessage());
            return responses;
        }
        if(!cont.equals(usuarioRepository.count())){
            responses.setCodigo("00");
            responses.setMensajeError("Usuario eliminado");
        }
        return responses;
    }

    public UsuarioModel actualizarUsuario(UsuarioModel usuarioModel){
        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel getObtenerUsuario(String cedula){
        Optional<UsuarioModel> usuarioModel;
        usuarioModel = Optional.ofNullable(usuarioRepository.getUsuario(cedula));
        return usuarioModel.get();
    }

}
