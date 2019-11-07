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
public class Reserva {
    private  Long reserva_id;
    private  Date fecha;
    private  Long cantidad_persona;
    private  Long rut_cliente;
    private  String e_mail_cliente;
    private  String fono_cliente;
    private  String nombre;
    private  String hora_inicio;
    private  String comentarios;

    public Reserva() {
    }

    public Reserva(Date fecha, Long cantidad_persona, Long rut_cliente, String e_mail_cliente, String fono_cliente, String nombre, String hora_inicio, String comentarios) {
        this.fecha = fecha;
        this.cantidad_persona = cantidad_persona;
        this.rut_cliente = rut_cliente;
        this.e_mail_cliente = e_mail_cliente;
        this.fono_cliente = fono_cliente;
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.comentarios = comentarios;
    }

    public Reserva(Long reserva_id, Date fecha, Long cantidad_persona, Long rut_cliente, String e_mail_cliente, String fono_cliente, String nombre, String hora_inicio, String comentarios) {
        this.reserva_id = reserva_id;
        this.fecha = fecha;
        this.cantidad_persona = cantidad_persona;
        this.rut_cliente = rut_cliente;
        this.e_mail_cliente = e_mail_cliente;
        this.fono_cliente = fono_cliente;
        this.nombre = nombre;
        this.hora_inicio = hora_inicio;
        this.comentarios = comentarios;
    }

    public Long getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(Long reserva_id) {
        this.reserva_id = reserva_id;
    }

    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getCantidad_persona() {
        return cantidad_persona;
    }

    public void setCantidad_persona(Long cantidad_persona) {
        this.cantidad_persona = cantidad_persona;
    }

    public Long getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(Long rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public String getE_mail_cliente() {
        return e_mail_cliente;
    }

    public void setE_mail_cliente(String e_mail_cliente) {
        this.e_mail_cliente = e_mail_cliente;
    }

    public String getFono_cliente() {
        return fono_cliente;
    }

    public void setFono_cliente(String fono_cliente) {
        this.fono_cliente = fono_cliente;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
