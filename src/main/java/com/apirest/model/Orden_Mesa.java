/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.model;

import java.util.Date;

/**
 *
 * @author jhon.carrasco
 */
public class Orden_Mesa {
    private Long order_mesa_id;
    private Long mesa_id;
    private Long usuario_id;
    private Date fecha;
    private Long total;
    private Long estado;

    public Orden_Mesa() {
    }

    public Orden_Mesa(Long mesa_id, Long usuario_id, Date fecha, Long total, Long estado) {
        this.mesa_id = mesa_id;
        this.usuario_id = usuario_id;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public Orden_Mesa(Long order_mesa_id, Long mesa_id, Long usuario_id, Date fecha, Long total, Long estado) {
        this.order_mesa_id = order_mesa_id;
        this.mesa_id = mesa_id;
        this.usuario_id = usuario_id;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public Long getOrder_mesa_id() {
        return order_mesa_id;
    }

    public void setOrder_mesa_id(Long order_mesa_id) {
        this.order_mesa_id = order_mesa_id;
    }

    public Long getMesa_id() {
        return mesa_id;
    }

    public void setMesa_id(Long mesa_id) {
        this.mesa_id = mesa_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
    
}
