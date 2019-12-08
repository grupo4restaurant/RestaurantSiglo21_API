/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.Categoria_MenuDao;
import com.apirest.dao.DominioDao;
import com.apirest.model.Categoria_Menu;
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
public class Categoria_MenuController {
    
    private static final Logger log = LoggerFactory.getLogger(DominioController.class);
    
   
    @Autowired
    Categoria_MenuDao dao;

    @PutMapping("/categoria_menu")
    public boolean agregarDominio(@RequestBody @Valid Categoria_Menu obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/categoria_menu")
    public boolean actualizarDominio(@RequestBody @Valid Categoria_Menu obj) {
        Integer estado = dao.actualizar(obj); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @DeleteMapping("/categoria_menu/{id}")
    public boolean borrarDominio(@PathVariable("id") long id) {
        Integer estado = dao.borrar(id); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @GetMapping("/categoria_menu/{id}")
    public List<Categoria_Menu> ObtenerCategoria_menuPorID(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
    @GetMapping("/categoria_menus")
    public List<Categoria_Menu> ObtenerTodoCategoria_menu() {               
        return dao.obtenerTodo();
    }
}
