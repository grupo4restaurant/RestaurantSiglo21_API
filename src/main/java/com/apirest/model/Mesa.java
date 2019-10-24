/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.model;

/**
 *
 * @author jhon.carrasco
 */
public class Mesa {
    
    private Long mesa_id;
    private String mesa_numero;
    private Long mesa_estado;
    private Long mesa_capacidad;

    public Mesa() {
    }

    public Mesa(String mesa_numero, Long mesa_estado, Long mesa_capacidad) {
        this.mesa_numero = mesa_numero;
        this.mesa_estado = mesa_estado;
        this.mesa_capacidad = mesa_capacidad;
    }

    public Mesa(Long mesa_id, String mesa_numero, Long mesa_estado, Long mesa_capacidad) {
        this.mesa_id = mesa_id;
        this.mesa_numero = mesa_numero;
        this.mesa_estado = mesa_estado;
        this.mesa_capacidad = mesa_capacidad;
    }

    public Long getMesa_id() {
        return mesa_id;
    }

    public void setMesa_id(Long mesa_id) {
        this.mesa_id = mesa_id;
    }

    public String getMesa_numero() {
        return mesa_numero;
    }

    public void setMesa_numero(String mesa_numero) {
        this.mesa_numero = mesa_numero;
    }

    public Long getMesa_estado() {
        return mesa_estado;
    }

    public void setMesa_estado(Long mesa_estado) {
        this.mesa_estado = mesa_estado;
    }

    public Long getMesa_capacidad() {
        return mesa_capacidad;
    }

    public void setMesa_capacidad(Long mesa_capacidad) {
        this.mesa_capacidad = mesa_capacidad;
    }
    
}
