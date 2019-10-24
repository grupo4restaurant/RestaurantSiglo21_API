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
public class Unidad_Medida {
    private Long um_id;
    private Long unidad;
    private String simbologia;

    public Unidad_Medida() {
    }

    public Unidad_Medida(Long unidad, String simbologia) {
        this.unidad = unidad;
        this.simbologia = simbologia;
    }

    public Unidad_Medida(Long um_id, Long unidad, String simbologia) {
        this.um_id = um_id;
        this.unidad = unidad;
        this.simbologia = simbologia;
    }

    public Long getUm_id() {
        return um_id;
    }

    public void setUm_id(Long um_id) {
        this.um_id = um_id;
    }

    public Long getUnidad() {
        return unidad;
    }

    public void setUnidad(Long unidad) {
        this.unidad = unidad;
    }

    public String getSimbologia() {
        return simbologia;
    }

    public void setSimbologia(String simbologia) {
        this.simbologia = simbologia;
    }
    
}
