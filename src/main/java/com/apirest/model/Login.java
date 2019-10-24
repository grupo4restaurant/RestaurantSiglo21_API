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

public class Login {

    private Long login_id;
    private Long usuario_Id;
    private String login_pass;

    public Login() {
    }

    public Login(Long usuarioId, String contrasena) {
        this.usuario_Id = usuarioId;
        this.login_pass = contrasena;
    }

    public Login(Long id, Long usuarioId, String contrasena) {
        this.login_id = id;
        this.usuario_Id = usuarioId;
        this.login_pass = contrasena;
    }

    public Long getLogin_id() {
        return login_id;
    }

    public void setLogin_id(Long login_id) {
        this.login_id = login_id;
    }

    public Long getUsuario_Id() {
        return usuario_Id;
    }

    public void setUsuario_Id(Long usuario_Id) {
        this.usuario_Id = usuario_Id;
    }

    public String getLogin_pass() {
        return login_pass;
    }

    public void setLogin_pass(String login_pass) {
        this.login_pass = login_pass;
    }
    
}
