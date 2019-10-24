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
public class Detalle_Orden_Insumo {
    private Long det_ord_insumo_id;
    private Long orden_insumo_id;
    private Long producto_id;
    private Long um_id;
    private Long cantidad;
    private Long estado;

    public Detalle_Orden_Insumo(Long det_ord_insumo_id, Long orden_insumo_id, Long producto_id, Long um_id, Long cantidad, Long estado) {
        this.det_ord_insumo_id = det_ord_insumo_id;
        this.orden_insumo_id = orden_insumo_id;
        this.producto_id = producto_id;
        this.um_id = um_id;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Detalle_Orden_Insumo(Long orden_insumo_id, Long producto_id, Long um_id, Long cantidad, Long estado) {
        this.orden_insumo_id = orden_insumo_id;
        this.producto_id = producto_id;
        this.um_id = um_id;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Detalle_Orden_Insumo() {
    }

    public Long getDet_ord_insumo_id() {
        return det_ord_insumo_id;
    }

    public void setDet_ord_insumo_id(Long det_ord_insumo_id) {
        this.det_ord_insumo_id = det_ord_insumo_id;
    }

    public Long getOrden_insumo_id() {
        return orden_insumo_id;
    }

    public void setOrden_insumo_id(Long orden_insumo_id) {
        this.orden_insumo_id = orden_insumo_id;
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

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
    
}
