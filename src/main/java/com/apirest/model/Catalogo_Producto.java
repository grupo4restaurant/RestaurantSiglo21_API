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
public class Catalogo_Producto {
    private Long cat_prod_id;
    private String nombre;

    public Catalogo_Producto() {
    }

    public Catalogo_Producto(String nombre) {
        this.nombre = nombre;
    }

    public Catalogo_Producto(Long cat_prod_id, String nombre) {
        this.cat_prod_id = cat_prod_id;
        this.nombre = nombre;
    }

    public Long getCat_prod_id() {
        return cat_prod_id;
    }

    public void setCat_prod_id(Long cat_prod_id) {
        this.cat_prod_id = cat_prod_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
