package com.prueba.demo.servicesTest;

import com.prueba.demo.DummyMock;
import com.prueba.demo.models.Responses;
import com.prueba.demo.models.UsuarioModel;
import com.prueba.demo.repositories.UsuarioRepository;
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
public class TestServices {

    @InjectMocks
    UsuarioService usuarioService;

    @Mock
    UsuarioRepository usuarioRepository;

    DummyMock dummyMock;

    public TestServices(){
        dummyMock = new DummyMock();
    }

    @Test
    public void testControllerGet() {
        Mockito.when(usuarioRepository.findAll()).thenReturn(dummyMock.getUsers());
        ArrayList<UsuarioModel> models = usuarioService.getObtenerUsuarios();
        Assert.assertNotNull(models);
    }

    @Test
    public void testControllerGetDato() {
        Mockito.when(usuarioRepository.getUsuario(Mockito.any())).thenReturn(dummyMock.getUsuario());
        UsuarioModel usuarioModel = usuarioService.getObtenerUsuario("123456789");
        Assert.assertNotNull(usuarioModel);
    }

    @Test
    public void testControllerPost() {
        Mockito.when(usuarioRepository.save(Mockito.any())).thenReturn(dummyMock.getUsuario());
        UsuarioModel usuarioModel = usuarioService.guardarUsuario(dummyMock.getUsuario());
        Assert.assertNotNull(usuarioModel);
    }

    @Test
    public void testControllerPut() {
        Mockito.when(usuarioRepository.save(Mockito.any())).thenReturn(dummyMock.getUsuario());
        UsuarioModel usuarioModel = usuarioService.actualizarUsuario(dummyMock.getUsuario());
        Assert.assertNotNull(usuarioModel);
    }

}
