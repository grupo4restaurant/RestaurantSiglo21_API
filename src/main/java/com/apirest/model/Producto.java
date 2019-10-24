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
public class Producto {
    private Long producto_id;
    private Long cat_prod_id;
    private Long proveedor_id;
    private String nombre;
    private String cod;
    private Long valor_neto;

    public Producto() {
    }

    public Producto(Long cat_prod_id, Long proveedor_id, String nombre, String cod, Long valor_neto) {
        this.cat_prod_id = cat_prod_id;
        this.proveedor_id = proveedor_id;
        this.nombre = nombre;
        this.cod = cod;
        this.valor_neto = valor_neto;
    }

    public Producto(Long producto_id, Long cat_prod_id, Long proveedor_id, String nombre, String cod, Long valor_neto) {
        this.producto_id = producto_id;
        this.cat_prod_id = cat_prod_id;
        this.proveedor_id = proveedor_id;
        this.nombre = nombre;
        this.cod = cod;
        this.valor_neto = valor_neto;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getCat_prod_id() {
        return cat_prod_id;
    }

    public void setCat_prod_id(Long cat_prod_id) {
        this.cat_prod_id = cat_prod_id;
    }

    public Long getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Long proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Long getValor_neto() {
        return valor_neto;
    }

    public void setValor_neto(Long valor_neto) {
        this.valor_neto = valor_neto;
    }
    
}
