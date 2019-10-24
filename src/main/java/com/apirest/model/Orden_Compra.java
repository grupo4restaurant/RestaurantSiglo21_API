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
public class Orden_Compra {
    private Long orden_compra_id;
    private Long total_val_neto;
    private Long total_val_iva;
    private Long fecha_creacion;
    private Long fecha_gestionada;
    private Long fecha_recepcion;
    private Long estado;

    public Orden_Compra() {
    }

    public Orden_Compra(Long total_val_neto, Long total_val_iva, Long fecha_creacion, Long fecha_gestionada, Long fecha_recepcion, Long estado) {
        this.total_val_neto = total_val_neto;
        this.total_val_iva = total_val_iva;
        this.fecha_creacion = fecha_creacion;
        this.fecha_gestionada = fecha_gestionada;
        this.fecha_recepcion = fecha_recepcion;
        this.estado = estado;
    }

    public Orden_Compra(Long orden_compra_id, Long total_val_neto, Long total_val_iva, Long fecha_creacion, Long fecha_gestionada, Long fecha_recepcion, Long estado) {
        this.orden_compra_id = orden_compra_id;
        this.total_val_neto = total_val_neto;
        this.total_val_iva = total_val_iva;
        this.fecha_creacion = fecha_creacion;
        this.fecha_gestionada = fecha_gestionada;
        this.fecha_recepcion = fecha_recepcion;
        this.estado = estado;
    }

    public Long getOrden_compra_id() {
        return orden_compra_id;
    }

    public void setOrden_compra_id(Long orden_compra_id) {
        this.orden_compra_id = orden_compra_id;
    }

    public Long getTotal_val_neto() {
        return total_val_neto;
    }

    public void setTotal_val_neto(Long total_val_neto) {
        this.total_val_neto = total_val_neto;
    }

    public Long getTotal_val_iva() {
        return total_val_iva;
    }

    public void setTotal_val_iva(Long total_val_iva) {
        this.total_val_iva = total_val_iva;
    }

    public Long getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Long fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Long getFecha_gestionada() {
        return fecha_gestionada;
    }

    public void setFecha_gestionada(Long fecha_gestionada) {
        this.fecha_gestionada = fecha_gestionada;
    }

    public Long getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Long fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }
    
}
