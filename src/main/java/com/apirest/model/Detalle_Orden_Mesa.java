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
public class Detalle_Orden_Mesa {
    private Long det_ord_mesa_id;
    private Long menu_id;
    private Long order_mesa_id;
    private Long cantidad;
    private Long estado;

    public Detalle_Orden_Mesa() {
    }

    public Detalle_Orden_Mesa(Long menu_id, Long order_mesa_id, Long cantidad, Long estado) {
        this.menu_id = menu_id;
        this.order_mesa_id = order_mesa_id;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Detalle_Orden_Mesa(Long det_ord_mesa_id, Long menu_id, Long order_mesa_id, Long cantidad, Long estado) {
        this.det_ord_mesa_id = det_ord_mesa_id;
        this.menu_id = menu_id;
        this.order_mesa_id = order_mesa_id;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Long getDet_ord_mesa_id() {
        return det_ord_mesa_id;
    }

    public void setDet_ord_mesa_id(Long det_ord_mesa_id) {
        this.det_ord_mesa_id = det_ord_mesa_id;
    }

    public Long getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Long menu_id) {
        this.menu_id = menu_id;
    }

    public Long getOrder_mesa_id() {
        return order_mesa_id;
    }

    public void setOrder_mesa_id(Long order_mesa_id) {
        this.order_mesa_id = order_mesa_id;
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
