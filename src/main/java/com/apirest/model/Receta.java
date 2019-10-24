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
public class Receta {
    private Long receta_id;
    private Long item_id;
    private Long precedimiento;
    private Long nombre;
    private Long tiempo_prep;

    public Receta() {
    }

    public Receta(Long item_id, Long procedimiento, Long nombre, Long tiempo_prep) {
        this.item_id = item_id;
        this.precedimiento = procedimiento;
        this.nombre = nombre;
        this.tiempo_prep = tiempo_prep;
    }

    public Receta(Long receta_id, Long item_id, Long procedimiento, Long nombre, Long tiempo_prep) {
        this.receta_id = receta_id;
        this.item_id = item_id;
        this.precedimiento = procedimiento;
        this.nombre = nombre;
        this.tiempo_prep = tiempo_prep;
    }

    public Long getReceta_id() {
        return receta_id;
    }

    public void setReceta_id(Long receta_id) {
        this.receta_id = receta_id;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public Long getPrecedimiento() {
        return precedimiento;
    }

    public void setPrecedimiento(Long precedimiento) {
        this.precedimiento = precedimiento;
    }

    public Long getNombre() {
        return nombre;
    }

    public void setNombre(Long nombre) {
        this.nombre = nombre;
    }

    public Long getTiempo_prep() {
        return tiempo_prep;
    }

    public void setTiempo_prep(Long tiempo_prep) {
        this.tiempo_prep = tiempo_prep;
    }
    
}
