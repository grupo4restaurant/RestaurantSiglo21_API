/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.siglo21.service;

/**
 *
 * @author jhon.carrasco
 */
import com.apirest.siglo21.converter.Convertidor;
import com.apirest.siglo21.entity.Nota;
import com.apirest.siglo21.model.MNota;
import com.apirest.siglo21.repository.NotaRepositorio;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;





@Service("servicio")
public class NotaService {
	@Autowired
	@Qualifier("repositorio")
	private NotaRepositorio repositorio;
	
	@Autowired
	@Qualifier("convertidor")
	private Convertidor convertidor;
	
	//logs de informacion
	private static final Log logger = LogFactory.getLog(NotaService.class);
	
	public boolean crear(Nota nota) {
		logger.info("CREANDO NOTA");
		try {
			repositorio.save(nota);
			logger.info("NOTA CREADA");
			return true;
		}catch(Exception e) {
			logger.error("ERROR EN LA CREACION");
			return false;
		}
	}
	public boolean actualizar(Nota nota) {
		try {
			repositorio.save(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public boolean borrar(String nombre, long id ) {
		try {
			Nota nota = repositorio.findByNombreAndId(nombre, id);
			repositorio.delete(nota);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	public List<MNota> obtener(){
		return convertidor.convertirLista(repositorio.findAll());
	}
	public MNota obtenerPorNombreTitulo(String nombre, String titulo) {
		return new MNota(repositorio.findByNombreAndTitulo(nombre, titulo));
	}
	public List<MNota> obtenerTitulo(String titulo){
		return convertidor.convertirLista(repositorio.findByTitulo(titulo));
	}
	public List<MNota> obtenerPorPaginacion(Pageable pageable){
		return convertidor.convertirLista(repositorio.findAll(pageable).getContent());
	}
}