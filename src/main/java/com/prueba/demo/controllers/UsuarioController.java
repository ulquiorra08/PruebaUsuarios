package com.prueba.demo.controllers;

import com.prueba.demo.models.Responses;
import com.prueba.demo.models.UsuarioModel;
import com.prueba.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/gestionUsuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuairos(){
        return usuarioService.getObtenerUsuarios();
    }

    @PostMapping()
    @RequestMapping(value = "/guardar")
    public UsuarioModel guardarUsuario(@RequestBody UsuarioModel usuarioModel){
        return this.usuarioService.guardarUsuario(usuarioModel);
    }

    @DeleteMapping()
    @RequestMapping(value = "/eliminar", params = "id")
    public Responses eliminarUsuario(@RequestParam Long id){
        return usuarioService.eliminarUsuario(id);
    }

    @PutMapping()
    @RequestMapping(value = "/actualizar")
    public UsuarioModel actualizarUsuario(@RequestBody UsuarioModel usuarioModel){
        return usuarioService.actualizarUsuario(usuarioModel);
    }

    @GetMapping()
    @RequestMapping(value = "/usuario", params = "cedula")
    public UsuarioModel obtenerUsuairo(@RequestParam @Nullable String cedula){
        return usuarioService.getObtenerUsuario(cedula);
    }

}
