/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.RolDao;
import com.apirest.model.Rol;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class RolController {

    private static final Logger log = LoggerFactory.getLogger(RolController.class);
    
   
    @Autowired
    RolDao dao;

    @PutMapping("/rol")
    public Optional agregarRol(@RequestBody @Valid Rol obj) {
        Optional id = dao.crear(obj); 
        return id;
    }

    @PostMapping("/rol")
    public boolean actualizar(@RequestBody @Valid Rol obj) {
        Integer estado = dao.actualizar(obj); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @DeleteMapping("/rol/{id}")
    public boolean borrarNota(@PathVariable("id") long id) {
        Integer estado = dao.borrar(id); 
        
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @GetMapping("/rol/{id}")
    public List<Rol> ObtenerPorUsuarioId(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    @GetMapping("/roles/")
    public List<Rol> ObtenerTodoRoles() {               
        return dao.obtenerTodo();
    }
    
}
