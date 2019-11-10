/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.Orden_CompraDao;
import com.apirest.dao.ReservaDao;
import com.apirest.model.Orden_Compra;
import com.apirest.model.Reserva;
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
public class Orden_CompraController {

    private static final Logger log = LoggerFactory.getLogger(Orden_CompraController.class);
    
   
    @Autowired
    Orden_CompraDao dao;

    @PutMapping("/orden_compra")
    public boolean agregarReserva(@RequestBody @Valid Orden_Compra obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/orden_compra")
    public boolean actualizarReserva(@RequestBody @Valid Orden_Compra obj) {
        Integer estado = dao.actualizar(obj); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @DeleteMapping("/orden_compra/{id}")
    public boolean borrarReserva(@PathVariable("id") long id) {
        Integer estado = dao.borrar(id); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @GetMapping("/orden_compra/{id}")
    public List<Orden_Compra> ObtenerOrden_CompraPorID(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
}
