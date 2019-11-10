/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.dao.Orden_CompraDao;
import com.apirest.dao.Orden_InsumoDao;
import com.apirest.dao.ReservaDao;
import com.apirest.model.Orden_Compra;
import com.apirest.model.Orden_Insumo;
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
public class Orden_InsumoController {

    private static final Logger log = LoggerFactory.getLogger(Orden_InsumoController.class);
    
   
    @Autowired
    Orden_InsumoDao dao;

    @PutMapping("/orden_insumo")
    public boolean agregarReserva(@RequestBody @Valid Orden_Insumo obj) {
        Optional id = dao.crear(obj); 
        return id.isPresent();
    }

    @PostMapping("/orden_insumo")
    public boolean actualizarReserva(@RequestBody @Valid Orden_Insumo obj) {
        Integer estado = dao.actualizar(obj); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @DeleteMapping("/orden_insumo/{id}")
    public boolean borrarReserva(@PathVariable("id") long id) {
        Integer estado = dao.borrar(id); 
        boolean success = Optional.of(estado).equals(Optional.of(1));
        return success;
    }

    @GetMapping("/orden_insumo/{id}")
    public List<Orden_Insumo> ObtenerOrden_InsumoPorID(@PathVariable("id") long id) {               
        return dao.obtener(id);
    }
    
}
