/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.Catalogo_ProductoDao;
import com.apirest.dao.LoginDao;
import com.apirest.model.Catalogo_Producto;
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
public class Catalogo_ProductoController {

    private static final Logger log = LoggerFactory.getLogger(Catalogo_ProductoController.class);
    
   
    @Autowired
    Catalogo_ProductoDao dao;

    @PutMapping("/catalogo_producto")
    public boolean agregarNota(@RequestBody @Valid Catalogo_Producto obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/catalogo_producto")
    public boolean actualizarNota(@RequestBody @Valid Catalogo_Producto obj) {
        Optional estado = dao.actualizar(obj); 
        return estado.isPresent();
    }

    @DeleteMapping("/catalogo_producto/{id}")
    public boolean borrarNota(@PathVariable("id") long id) {
        Optional estado = dao.borrar(id); 
        return estado.isPresent();
    }

    @GetMapping("/catalogo_producto/{id}")
    public List<Catalogo_Producto> ObtenerPorUsuarioId(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
}
