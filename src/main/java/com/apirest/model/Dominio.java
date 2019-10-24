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
public class Dominio {
    private Long dom_id;
    private String dom_val_dom;
    private String dom_desc;
    private String dom_val;
    private Long dom_estado;

    public Dominio() {
    }

    public Dominio(Long dom_id, String dom_val_dom, String dom_desc, String dom_val, Long dom_estado) {
        this.dom_id = dom_id;
        this.dom_val_dom = dom_val_dom;
        this.dom_desc = dom_desc;
        this.dom_val = dom_val;
        this.dom_estado = dom_estado;
    }

    public Dominio(String dom_val_dom, String dom_desc, String dom_val, Long dom_estado) {
        this.dom_val_dom = dom_val_dom;
        this.dom_desc = dom_desc;
        this.dom_val = dom_val;
        this.dom_estado = dom_estado;
    }

    public Long getDom_id() {
        return dom_id;
    }

    public void setDom_id(Long dom_id) {
        this.dom_id = dom_id;
    }

    public String getDom_val_dom() {
        return dom_val_dom;
    }

    public void setDom_val_dom(String dom_val_dom) {
        this.dom_val_dom = dom_val_dom;
    }

    public String getDom_desc() {
        return dom_desc;
    }

    public void setDom_desc(String dom_desc) {
        this.dom_desc = dom_desc;
    }

    public String getDom_val() {
        return dom_val;
    }

    public void setDom_val(String dom_val) {
        this.dom_val = dom_val;
    }

    public Long getDom_estado() {
        return dom_estado;
    }

    public void setDom_estado(Long dom_estado) {
        this.dom_estado = dom_estado;
    }

}
