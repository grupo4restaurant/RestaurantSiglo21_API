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
public class Proveedor {
    private Long proveedor_id;
    private String nombre;
    private String fono;
    private String contacto;
    private String e_mail;
    private String direccion;
    private String comuna;

    public Proveedor() {
    }

    public Proveedor(String nombre, String fono, String contacto, String e_mail, String direccion, String comuna) {
        this.nombre = nombre;
        this.fono = fono;
        this.contacto = contacto;
        this.e_mail = e_mail;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    public Proveedor(Long proveedor_id, String nombre, String fono, String contacto, String e_mail, String direccion, String comuna) {
        this.proveedor_id = proveedor_id;
        this.nombre = nombre;
        this.fono = fono;
        this.contacto = contacto;
        this.e_mail = e_mail;
        this.direccion = direccion;
        this.comuna = comuna;
    }

    public Long getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(Long proveedor_id) {
        this.proveedor_id = proveedor_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }
    
}
