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
public class Detalle_Producto_Receta {
    private Long det_pro_receta_id;
    private Long receta_id;
    private Long producto_id;
    private Long um_id;
    private Long cantidad;

    public Detalle_Producto_Receta() {
    }

    public Detalle_Producto_Receta(Long receta_id, Long producto_id, Long um_id, Long cantidad) {
        this.receta_id = receta_id;
        this.producto_id = producto_id;
        this.um_id = um_id;
        this.cantidad = cantidad;
    }

    public Detalle_Producto_Receta(Long det_pro_receta_id, Long receta_id, Long producto_id, Long um_id, Long cantidad) {
        this.det_pro_receta_id = det_pro_receta_id;
        this.receta_id = receta_id;
        this.producto_id = producto_id;
        this.um_id = um_id;
        this.cantidad = cantidad;
    }

    public Long getDet_pro_receta_id() {
        return det_pro_receta_id;
    }

    public void setDet_pro_receta_id(Long det_pro_receta_id) {
        this.det_pro_receta_id = det_pro_receta_id;
    }

    public Long getReceta_id() {
        return receta_id;
    }

    public void setReceta_id(Long receta_id) {
        this.receta_id = receta_id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getUm_id() {
        return um_id;
    }

    public void setUm_id(Long um_id) {
        this.um_id = um_id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
    
}
