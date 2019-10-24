/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.Detalle_Producto_RecetaDao;
import com.apirest.model.Detalle_Producto_Receta;
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
public class Detalle_Producto_RecetaController {

    private static final Logger log = LoggerFactory.getLogger(Detalle_Producto_RecetaController.class);
    
   
    @Autowired
    Detalle_Producto_RecetaDao dao;

    @PutMapping("/detalle_producto_receta")
    public boolean agregarDetalle_Producto_Receta(@RequestBody @Valid Detalle_Producto_Receta obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/detalle_producto_receta")
    public boolean actualizarDetalle_Producto_Receta(@RequestBody @Valid Detalle_Producto_Receta obj) {
        Optional estado = dao.actualizar(obj); 
        return estado.isPresent();
    }

    @DeleteMapping("/detalle_producto_receta/{id}")
    public boolean borrarDetalle_Producto_Receta(@PathVariable("id") long id) {
        Optional estado = dao.borrar(id); 
        return estado.isPresent();
    }

    @GetMapping("/detalle_producto_receta/{id}")
    public List<Detalle_Producto_Receta> ObtenerDetalle_Producto_RecetaPorID(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
}
