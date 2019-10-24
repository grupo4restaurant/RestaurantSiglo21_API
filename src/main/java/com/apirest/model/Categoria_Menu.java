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
public class Categoria_Menu {
    private Long cat_menu_id;
    private String cat_menu_nombre;
    private Long cat_fase;

    public Categoria_Menu() {
    }

    public Categoria_Menu(String cat_menu_nombre, Long cat_fase) {
        this.cat_menu_nombre = cat_menu_nombre;
        this.cat_fase = cat_fase;
    }

    public Categoria_Menu(Long cat_menu_id, String cat_menu_nombre, Long cat_fase) {
        this.cat_menu_id = cat_menu_id;
        this.cat_menu_nombre = cat_menu_nombre;
        this.cat_fase = cat_fase;
    }

    public Long getCat_menu_id() {
        return cat_menu_id;
    }

    public void setCat_menu_id(Long cat_menu_id) {
        this.cat_menu_id = cat_menu_id;
    }

    public String getCat_menu_nombre() {
        return cat_menu_nombre;
    }

    public void setCat_menu_nombre(String cat_menu_nombre) {
        this.cat_menu_nombre = cat_menu_nombre;
    }

    public Long getCat_fase() {
        return cat_fase;
    }

    public void setCat_fase(Long cat_fase) {
        this.cat_fase = cat_fase;
    }
    
}
