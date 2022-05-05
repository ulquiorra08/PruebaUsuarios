package com.prueba.demo;

import com.prueba.demo.models.Responses;
import com.prueba.demo.models.UsuarioModel;

import javax.xml.ws.Response;
import java.util.ArrayList;

public class DummyMock {

    public ArrayList<UsuarioModel> getUsers(){
        UsuarioModel usuarioModel = new UsuarioModel();
        ArrayList<UsuarioModel> models = new ArrayList<>();
        usuarioModel.setId(1L);
        usuarioModel.setNombre("Tatiana");
        usuarioModel.setCorreo("Nose@gmail.com");
        usuarioModel.setDireccion("Nose");
        usuarioModel.setNumeroDocumento("123456789");
        usuarioModel.setNumeroTelefonico("123454687");
        usuarioModel.setTipoDocumento("CC");
        models.add(usuarioModel);
        models.add(usuarioModel);
        models.add(usuarioModel);
        return models;
    }

    public UsuarioModel getUsuario(){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(1L);
        usuarioModel.setNombre("Tatiana");
        usuarioModel.setCorreo("Nose@gmail.com");
        usuarioModel.setDireccion("Nose");
        usuarioModel.setNumeroDocumento("123456789");
        usuarioModel.setNumeroTelefonico("123454687");
        usuarioModel.setTipoDocumento("CC");
        return usuarioModel;
    }

    public Responses getResponse(){
        Responses responses = new Responses();
        responses.setCodigo("00");
        responses.setMensajeError("Excelente");
        return responses;
    }

    public Responses getResponseError(){
        Responses responses = new Responses();
        responses.setCodigo("01");
        responses.setMensajeError("No se pudo eliminar el usuario por: ");
        return responses;
    }

}
