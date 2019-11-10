/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.Detalle_Orden_MesaDao;
import com.apirest.dao.DominioDao;
import com.apirest.dao.RecetaDao;
import com.apirest.model.Detalle_Orden_Mesa;
import com.apirest.model.Dominio;
import com.apirest.model.Receta;
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
public class Detalle_Orden_MesaController {

    private static final Logger log = LoggerFactory.getLogger(Detalle_Orden_MesaController.class);
    
   
    @Autowired
    Detalle_Orden_MesaDao dao;

    @PutMapping("/detalle_orden_mesa")
    public boolean agregarReceta(@RequestBody @Valid Detalle_Orden_Mesa obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/detalle_orden_mesa")
    public boolean actualizarReceta(@RequestBody @Valid Detalle_Orden_Mesa obj) {
        Integer estado = dao.actualizar(obj); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @DeleteMapping("/detalle_orden_mesa/{id}")
    public boolean borrarReceta(@PathVariable("id") long id) {
        Integer estado = dao.borrar(id); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @GetMapping("/detalle_orden_mesa/{id}")
    public List<Detalle_Orden_Mesa> ObtenerDetalle_Orden_MesaPorID(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
}
