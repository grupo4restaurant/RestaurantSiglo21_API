/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.siglo21.controller;

/**
 *
 * @author jhon.carrasco
 */

import com.apirest.siglo21.entity.Nota;
import com.apirest.siglo21.model.MNota;
import com.apirest.siglo21.service.NotaService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/v1")
public class NotaController {
	
	@Autowired
	@Qualifier("servicio")
	NotaService service;

	@PutMapping("/nota")
	public boolean agregarNota(@RequestBody @Valid Nota nota) {
		return service.crear(nota);
	}
	@PostMapping("/nota")
	public boolean actualizarNota(@RequestBody @Valid Nota nota) {
		return service.actualizar(nota);
	}
	@DeleteMapping("/nota/{id}/{nombre}")
	public boolean borrarNota(@PathVariable("id") long id, @PathVariable("nombre") String nombre) {
		return service.borrar(nombre, id);
	}
	@GetMapping("/notas")
	public List<MNota> obtenerNotas() {
		return service.obtener();
	}
	@GetMapping("/notas2")
	public List<MNota> obtenerNotas2(Pageable pageable) {
		return service.obtenerPorPaginacion(pageable);
	}
}
