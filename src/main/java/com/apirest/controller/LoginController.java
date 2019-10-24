/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.LoginDao;
import com.apirest.model.Login;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhon.carrasco
 */
@RestController
@RequestMapping("/siglo21")
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);
    
   
    @Autowired
    LoginDao loginDao;

    @PutMapping("/login")
    public boolean agregarNota(@RequestBody @Valid Login login) {
        Optional id = loginDao.crear(login); 
        return id.isPresent();
    }

    @PostMapping("/login")
    public boolean actualizarNota(@RequestBody @Valid Login login) {
        Optional estado = loginDao.actualizar(login); 
        return estado.isPresent();
    }

    @DeleteMapping("/login/{id}")
    public boolean borrarNota(@PathVariable("id") long id) {
        Optional estado = loginDao.borrar(id); 
        return estado.isPresent();
    }

    @GetMapping("/login/{usuario_id}")
    public List<Login> ObtenerPorUsuarioId(@PathVariable("usuario_id") long usuario_id) {               
        return loginDao.obtener(usuario_id);
    }
    
}
