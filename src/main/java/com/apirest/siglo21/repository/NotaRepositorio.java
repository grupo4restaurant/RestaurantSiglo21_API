/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.siglo21.repository;

/**
 *
 * @author jhon.carrasco
 */
import com.apirest.siglo21.entity.Nota;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;





@Repository("repositorio")
public interface NotaRepositorio extends JpaRepository<Nota, Serializable>, PagingAndSortingRepository<Nota, Serializable>{
	
	public abstract Nota findByNombre(String nombre);
	
	public abstract List<Nota> findByTitulo(String titulo);
	
	public abstract Nota findByNombreAndTitulo(String nombre, String titulo);
	
	public abstract Nota findByNombreAndId(String nombre, long id);
	
        @Override
	public abstract Page<Nota> findAll(Pageable pageable);
}