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
public class Orden_Insumo {
    private Long orden_insumo_id;
    private Date fecha_creacion;
    private Date fecha_gestionada;
    private Date fecha_recepcion;
    private Long estado;

    public Orden_Insumo() {
    }

    public Orden_Insumo(Date fecha_creacion, Date fecha_gestionada, Date fecha_recepcion, Long estado) {
        this.fecha_creacion = fecha_creacion;
        this.fecha_gestionada = fecha_gestionada;
        this.fecha_recepcion = fecha_recepcion;
        this.estado = estado;
    }

    public Orden_Insumo(Long orden_insumo_id, Date fecha_creacion, Date fecha_gestionada, Date fecha_recepcion, Long estado) {
        this.orden_insumo_id = orden_insumo_id;
        this.fecha_creacion = fecha_creacion;
        this.fecha_gestionada = fecha_gestionada;
        this.fecha_recepcion = fecha_recepcion;
        this.estado = estado;
    }

    public Long getOrden_insumo_id() {
        return orden_insumo_id;
    }

    public void setOrden_insumo_id(Long orden_insumo_id) {
        this.orden_insumo_id = orden_insumo_id;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_gestionada() {
        return fecha_gestionada;
    }

    public void setFecha_gestionada(Date fecha_gestionada) {
        this.fecha_gestionada = fecha_gestionada;
    }

    public Date getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Date fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
    
}
