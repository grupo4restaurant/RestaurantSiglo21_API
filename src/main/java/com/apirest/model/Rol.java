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
public class Rol {
    
    private Long rol_id;
    private String rol_desc;
    private Long rol_index;

    public Rol() {
    }

    public Rol(String rol_desc, Long rol_index) {
        this.rol_desc = rol_desc;
        this.rol_index = rol_index;
    }

    public Rol(Long rol_id, String rol_desc, Long rol_index) {
        this.rol_id = rol_id;
        this.rol_desc = rol_desc;
        this.rol_index = rol_index;
    }

    public Long getRol_id() {
        return rol_id;
    }

    public void setRol_id(Long rol_id) {
        this.rol_id = rol_id;
    }

    public String getRol_desc() {
        return rol_desc;
    }

    public void setRol_desc(String rol_desc) {
        this.rol_desc = rol_desc;
    }

    public Long getRol_index() {
        return rol_index;
    }

    public void setRol_index(Long rol_index) {
        this.rol_index = rol_index;
    }
    
    
    
}
