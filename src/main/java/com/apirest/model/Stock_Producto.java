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
public class Stock_Producto {
    private Long stock_id;
    private Long producto_id;
    private Long cantidad;
    private Long minimo;

    public Stock_Producto() {
    }

    public Stock_Producto(Long producto_id, Long cantidad, Long minimo) {
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.minimo = minimo;
    }

    public Stock_Producto(Long stock_id, Long producto_id, Long cantidad, Long minimo) {
        this.stock_id = stock_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.minimo = minimo;
    }

    public Long getStock_id() {
        return stock_id;
    }

    public void setStock_id(Long stock_id) {
        this.stock_id = stock_id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getMinimo() {
        return minimo;
    }

    public void setMinimo(Long minimo) {
        this.minimo = minimo;
    }
    
}
