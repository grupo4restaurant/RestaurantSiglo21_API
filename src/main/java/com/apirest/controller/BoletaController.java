/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.BoletaDao;
import com.apirest.model.Boleta;
import com.apirest.model.Proveedor;
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
public class BoletaController {

    private static final Logger log = LoggerFactory.getLogger(BoletaController.class);
    
   
    @Autowired
    BoletaDao dao;

    @PutMapping("/boleta")
    public boolean agregarUsuario(@RequestBody @Valid Boleta obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/boleta")
    public boolean actualizarUsuario(@RequestBody @Valid Boleta obj) {
        Optional estado = dao.actualizar(obj); 
        return estado.isPresent();
    }

    @DeleteMapping("/boleta/{id}")
    public boolean borrarUsuario(@PathVariable("id") long id) {
        Optional estado = dao.borrar(id); 
        return estado.isPresent();
    }

    @GetMapping("/boleta/{id}")
    public List<Boleta> ObtenerUsuarioPorID(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
}
