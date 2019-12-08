package com.apirest.dao;

import com.apirest.model.Dominio;
import com.apirest.model.Menu_Item;
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
public class Menu_ItemDao {

    private static final Logger log = LoggerFactory.getLogger(Menu_ItemDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Variables SimpleJdbcCall de Procedimientos Almacenados    
    private SimpleJdbcCall obtener;
    private SimpleJdbcCall crear;
    private SimpleJdbcCall actualizar;
    private SimpleJdbcCall borrar;
    private SimpleJdbcCall obtenerTodo;
    private SimpleJdbcCall obtenerTodoPorIdCategoria;

    // init SimpleJdbcCall
    @PostConstruct
    void init() {
        //sensitivo upcase o downcase
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        //insertar
        crear = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_CREAR_MENU_ITEM");
        // Convert SYS_REFCURSOR to List
        obtener = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_MENU_ITEM")
                .returningResultSet("OUT_PC_GET_MENU_ITEM",
                        BeanPropertyRowMapper.newInstance(Menu_Item.class));
        //actualizar
        actualizar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_UPD_MENU_ITEM");
        //borrar
        borrar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DEL_MENU_ITEM");
        obtenerTodo = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_ALL_MENU_ITEM")
                .returningResultSet("OUT_PC_GET_MENU_ITEM",
                        BeanPropertyRowMapper.newInstance(Menu_Item.class));
        obtenerTodoPorIdCategoria = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_MENU_ITEM_BY_CATEG_ID")
                .returningResultSet("OUT_PC_GET_MENU_ITEM",
                        BeanPropertyRowMapper.newInstance(Menu_Item.class));
    }

    //insertar
    public Optional crear(Menu_Item obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_CAT_MENU_ID", obj.getCat_menu_id())
                                                           .addValue("IN_ITEM_NOMBRE", obj.getItem_nombre())
                                                            .addValue("IN_ITEM_DESC", obj.getItem_desc())
                                                            .addValue("IN_ITEM_VAL", obj.getItem_val());
                                                            
                                                            
        Optional result = Optional.empty();
        
        try{
            Map out = crear.execute(in);
            if (out != null){
                BigDecimal OUT_ID_SALIDA = (BigDecimal) out.get("OUT_ID_SALIDA");
                result = Optional.of(OUT_ID_SALIDA);
            }
        }catch(Exception e){
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    //actualizar
    public Integer actualizar(Menu_Item obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_ITEM_ID", obj.getItem_id())
                                                           .addValue("IN_CAT_MENU_ID", obj.getCat_menu_id())
                                                           .addValue("IN_ITEM_NOMBRE", obj.getItem_nombre())
                                                            .addValue("IN_ITEM_DESC", obj.getItem_desc())
                                                            .addValue("IN_ITEM_VAL", obj.getItem_val());
        Integer result = 0;
        
        try{
            Map out = actualizar.execute(in);
            if (out != null){
                String OUT_ID_SALIDA = (String) out.get("OUT_GLOSA");
                BigDecimal OUT_ESTADO = (BigDecimal) out.get("OUT_ESTADO");
                
                result = OUT_ESTADO.intValue();
            }
        }catch(Exception e){
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    //borrar
    public Integer borrar(Long id){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_ITEM_ID", id);
        Integer result = 0;
        
        try{
            Map out = borrar.execute(in);
            if (out != null){
                String OUT_ID_SALIDA = (String) out.get("OUT_GLOSA");
                BigDecimal OUT_ESTADO = (BigDecimal) out.get("OUT_ESTADO");
                
                result = OUT_ESTADO.intValue();
            }
        }catch(Exception e){
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    //obtener
    public List<Menu_Item> obtener(Long id) {

        log.info("SP_GET_MENU_ITEM.obtener...");

        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_ITEM_ID", id);

        Map out = obtener.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_MENU_ITEM");
        }
    }    
    
    //obtenerTodo
    public List<Menu_Item> obtenerTodo() {

        log.info("SP_GET_All_MENU_ITEM.obtenerTodo...");

        Map out = obtenerTodo.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_MENU_ITEM");
        }
    }    
    
    //obtenerTodo por id categoria
    public List<Menu_Item> obtenerTodoPorIdCategoria(Long idCategoria) {

        log.info("SP_GET_MENU_ITEM_BY_CATEG_ID.obtenerTodoPorIdCategoria...");
        
        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_CAT_MENU_ID", idCategoria);

        Map out = obtenerTodoPorIdCategoria.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_MENU_ITEM");
        }
    }    
}
