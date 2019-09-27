/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.siglo21.entity;

/**
 *
 * @author jhon.carrasco
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NOTA")
public class Nota implements Serializable{
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "NOTA")
	@Id
	@Column(name="ID_NOTA")
	private long id;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="CONTENIDO")
	private String contenido;
	
	
	
	public Nota() {
            
	
	}
	public Nota(long id, String nombre, String titulo, String contenido) {
		
		this.id = id;
		this.nombre = nombre;
		this.titulo = titulo;
		this.contenido = contenido;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}