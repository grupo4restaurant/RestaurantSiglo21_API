/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.siglo21.converter;

/**
 *
 * @author jhon.carrasco
 */
import com.apirest.siglo21.entity.Nota;
import com.apirest.siglo21.model.MNota;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;



@Component("convertidor")
public class Convertidor {
	public List<MNota> convertirLista(List<Nota> notas){
		List<MNota> mnotas = new ArrayList<>();
		for(Nota nota : notas) {
			mnotas.add(new MNota(nota));
		}
		return mnotas;
	}
}