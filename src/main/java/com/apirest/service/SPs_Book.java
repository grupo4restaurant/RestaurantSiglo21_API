package com.apirest.service;

import com.apirest.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

@Component
public class SPs_Book {

    private static final Logger log = LoggerFactory.getLogger(SPs_Book.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Variables SimpleJdbcCall de Procedimientos Almacenados
    private SimpleJdbcCall get_book_by_id;
    private SimpleJdbcCall get_book_by_name;
    

    // init SimpleJdbcCall
    @PostConstruct
    void init() {
        // o_name y O_NAME, sensitivo upcase o downcase
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        //Asignación Procecedimientos almacenados
        get_book_by_id = new SimpleJdbcCall(jdbcTemplate).withProcedureName("get_book_by_id");
        // Convert o_c_book SYS_REFCURSOR to List<Book>
        get_book_by_name = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("get_book_by_name")
                .returningResultSet("o_c_book",
                        BeanPropertyRowMapper.newInstance(Book.class));
        
    }

    public Book getById(Long id) {

        log.info("SP_Nuevo...");
        Book book = findById(id).orElseThrow(IllegalArgumentException::new);
        return book;
    }   
    Optional<Book> findById(Long id) {
        //p_id nombre del parametro en el sp
        SqlParameterSource in = new MapSqlParameterSource().addValue("p_id", id);
        Optional result = Optional.empty();

        try {

            Map out = get_book_by_id.execute(in);
            if (out != null) {
                Book book = new Book();
                book.setId(id);
                //o_name y o_price nombre de los parametros en el sp
                book.setName((String) out.get("O_NAME"));
                book.setPrice((BigDecimal) out.get("O_PRICE"));
                result = Optional.of(book);
            }
        } catch (Exception e) {
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
        }
        return result;
    }
    public List<Book> getAllLikeByName(String name) {

        log.info("Creating Store Procedures and Function...");
        return findBookByName(name);

    }
    List<Book> findBookByName(String name) {

        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("p_name", name);

        Map out = get_book_by_name.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("o_c_book");
        }
    }

}
