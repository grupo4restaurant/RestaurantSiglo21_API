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
public class Detalle_Orden_Compra {
    private Long det_ord_compra_id;
    private Long producto_id;
    private Long orden_compra_id;
    private Long cantidad;
    private Long total_neto;
    private Long estado;

    public Detalle_Orden_Compra() {
    }

    public Detalle_Orden_Compra(Long producto_id, Long orden_compra_id, Long cantidad, Long total_neto, Long estado) {
        this.producto_id = producto_id;
        this.orden_compra_id = orden_compra_id;
        this.cantidad = cantidad;
        this.total_neto = total_neto;
        this.estado = estado;
    }

    public Detalle_Orden_Compra(Long det_ord_compra_id, Long producto_id, Long orden_compra_id, Long cantidad, Long total_neto, Long estado) {
        this.det_ord_compra_id = det_ord_compra_id;
        this.producto_id = producto_id;
        this.orden_compra_id = orden_compra_id;
        this.cantidad = cantidad;
        this.total_neto = total_neto;
        this.estado = estado;
    }

    public Long getDet_ord_compra_id() {
        return det_ord_compra_id;
    }

    public void setDet_ord_compra_id(Long det_ord_compra_id) {
        this.det_ord_compra_id = det_ord_compra_id;
    }

    public Long getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(Long producto_id) {
        this.producto_id = producto_id;
    }

    public Long getOrden_compra_id() {
        return orden_compra_id;
    }

    public void setOrden_compra_id(Long orden_compra_id) {
        this.orden_compra_id = orden_compra_id;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public Long getTotal_neto() {
        return total_neto;
    }

    public void setTotal_neto(Long total_neto) {
        this.total_neto = total_neto;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
    
}
