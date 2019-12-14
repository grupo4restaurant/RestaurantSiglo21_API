/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.ProductoDao;
import com.apirest.dao.ProveedorDao;
import com.apirest.model.Producto;
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
public class ProductoController {

    private static final Logger log = LoggerFactory.getLogger(ProductoController.class);
    
   
    @Autowired
    ProductoDao dao;

    @PutMapping("/producto")
    public boolean agregarUsuario(@RequestBody @Valid Producto obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/producto")
    public boolean actualizarUsuario(@RequestBody @Valid Producto obj) {
        Integer estado = dao.actualizar(obj); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @DeleteMapping("/producto/{id}")
    public boolean borrarUsuario(@PathVariable("id") long id) {
        Integer estado = dao.borrar(id); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @GetMapping("/producto/{id}")
    public List<Producto> ObtenerProductoPorID(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
    @GetMapping("/productos/{id}")
    public List<Producto> ObtenerProductosPorCategoria(@PathVariable("id") long id) {               
        return dao.obtenerPorCategoria(id);
    }
    
    @GetMapping("/productos")
    public List<Producto> ObtenerTodo() {               
        return dao.obtenerTodo();
    }
    
}
