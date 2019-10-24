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
public class Usuario {
    private Long usuario_id;
    private Long rol_id;
    private String nombre;
    private String ap_paterno;
    private String ap_materno;
    private String e_mail;
    private String fono;

    public Usuario() {
    }

    public Usuario(Long rol_id, String nombre, String ap_paterno, String ap_materno, String e_mail, String fono) {
        this.rol_id = rol_id;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.e_mail = e_mail;
        this.fono = fono;
    }

    public Usuario(Long usuario_id, Long rol_id, String nombre, String ap_paterno, String ap_materno, String e_mail, String fono) {
        this.usuario_id = usuario_id;
        this.rol_id = rol_id;
        this.nombre = nombre;
        this.ap_paterno = ap_paterno;
        this.ap_materno = ap_materno;
        this.e_mail = e_mail;
        this.fono = fono;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Long getRol_id() {
        return rol_id;
    }

    public void setRol_id(Long rol_id) {
        this.rol_id = rol_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }
    
}
