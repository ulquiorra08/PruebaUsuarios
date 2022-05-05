package com.prueba.demo.controllerTest;

import com.prueba.demo.DummyMock;
import com.prueba.demo.controllers.UsuarioController;
import com.prueba.demo.models.Responses;
import com.prueba.demo.models.UsuarioModel;
import com.prueba.demo.services.UsuarioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class TestController {

    @InjectMocks
    UsuarioController usuarioController;

    @Mock
    UsuarioService usuarioService;

    DummyMock dummyMock;

    public TestController(){
        dummyMock = new DummyMock();
    }

    @Test
    public void testControllerGet() {
        Mockito.when(usuarioService.getObtenerUsuarios()).thenReturn(dummyMock.getUsers());
        ArrayList<UsuarioModel> models = usuarioController.obtenerUsuairos();
        Assert.assertNotNull(models);
    }

    @Test
    public void testControllerGetDato() {
        Mockito.when(usuarioService.getObtenerUsuario(Mockito.any())).thenReturn(dummyMock.getUsuario());
        UsuarioModel usuarioModel = usuarioController.obtenerUsuairo("123456789");
        Assert.assertNotNull(usuarioModel);
    }

    @Test
    public void testControllerPost() {
        Mockito.when(usuarioService.guardarUsuario(Mockito.any())).thenReturn(dummyMock.getUsuario());
        UsuarioModel usuarioModel = usuarioController.guardarUsuario(dummyMock.getUsuario());
        Assert.assertNotNull(usuarioModel);
    }

    @Test
    public void testControllerPut() {
        Mockito.when(usuarioService.actualizarUsuario(Mockito.any())).thenReturn(dummyMock.getUsuario());
        UsuarioModel usuarioModel = usuarioController.actualizarUsuario(dummyMock.getUsuario());
        Assert.assertNotNull(usuarioModel);
    }

    @Test
    public void testControllerDelete() {
        Mockito.when(usuarioService.eliminarUsuario(Mockito.any())).thenReturn(dummyMock.getResponse());
        Responses responses = usuarioController.eliminarUsuario(1L);
        Assert.assertNotNull(responses);
    }

    @Test
    public void testControllerDeleteNull() {
        Mockito.when(usuarioService.eliminarUsuario(Mockito.any())).thenReturn(dummyMock.getResponseError());
        Responses responses = usuarioController.eliminarUsuario(null);
        Assert.assertNotNull(responses);
    }

}
