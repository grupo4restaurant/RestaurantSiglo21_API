/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.controller;

import com.apirest.model.Book;
import com.apirest.service.SPs_Book;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhon.carrasco
 */
@RestController
@RequestMapping("/v1")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    
   
    @Autowired
    SPs_Book storedProcedure_nuevo;

    @Bean
    public LobHandler lobHandler() {
        return new DefaultLobHandler();
    }

    @GetMapping("/book/{id}")
    public Book ObtenerPorId(@PathVariable("id") long id) {
        Book book = storedProcedure_nuevo.getById(id);
        return book;
    }
    @GetMapping("/books/{name}")
    public List<Book> ObtenerSimilarPorNombre(@PathVariable("name") String name) {
        return storedProcedure_nuevo.getAllLikeByName(name);
    }
}
