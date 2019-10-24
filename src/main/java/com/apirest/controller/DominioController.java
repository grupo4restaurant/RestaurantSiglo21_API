/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.DominioDao;
import com.apirest.model.Dominio;
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
public class DominioController {

    private static final Logger log = LoggerFactory.getLogger(DominioController.class);
    
   
    @Autowired
    DominioDao dao;

    @PutMapping("/dominio")
    public boolean agregarDominio(@RequestBody @Valid Dominio obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/dominio")
    public boolean actualizarDominio(@RequestBody @Valid Dominio obj) {
        Optional estado = dao.actualizar(obj); 
        return estado.isPresent();
    }

    @DeleteMapping("/dominio/{id}")
    public boolean borrarDominio(@PathVariable("id") long id) {
        Optional estado = dao.borrar(id); 
        return estado.isPresent();
    }

    @GetMapping("/dominio/{id}")
    public List<Dominio> ObtenerDominioPorID(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
}
