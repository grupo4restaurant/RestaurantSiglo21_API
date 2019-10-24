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
public class Boleta {
    private Long boleta_id;
    private Long usuario_id;
    private Long orden_mesa_id;
    private Long fecha;
    private Long total_neto;
    private Long total_iva;
    private Long tipo_pago;

    public Boleta() {
    }

    public Boleta(Long usuario_id, Long orden_mesa_id, Long fecha, Long total_neto, Long total_iva, Long tipo_pago) {
        this.usuario_id = usuario_id;
        this.orden_mesa_id = orden_mesa_id;
        this.fecha = fecha;
        this.total_neto = total_neto;
        this.total_iva = total_iva;
        this.tipo_pago = tipo_pago;
    }

    public Boleta(Long boleta_id, Long usuario_id, Long orden_mesa_id, Long fecha, Long total_neto, Long total_iva, Long tipo_pago) {
        this.boleta_id = boleta_id;
        this.usuario_id = usuario_id;
        this.orden_mesa_id = orden_mesa_id;
        this.fecha = fecha;
        this.total_neto = total_neto;
        this.total_iva = total_iva;
        this.tipo_pago = tipo_pago;
    }

    public Long getBoleta_id() {
        return boleta_id;
    }

    public void setBoleta_id(Long boleta_id) {
        this.boleta_id = boleta_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Long getOrden_mesa_id() {
        return orden_mesa_id;
    }

    public void setOrden_mesa_id(Long orden_mesa_id) {
        this.orden_mesa_id = orden_mesa_id;
    }

    public Long getFecha() {
        return fecha;
    }

    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }

    public Long getTotal_neto() {
        return total_neto;
    }

    public void setTotal_neto(Long total_neto) {
        this.total_neto = total_neto;
    }

    public Long getTotal_iva() {
        return total_iva;
    }

    public void setTotal_iva(Long total_iva) {
        this.total_iva = total_iva;
    }

    public Long getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(Long tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
}
