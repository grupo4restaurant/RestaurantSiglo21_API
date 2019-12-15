package com.apirest.dao;

import com.apirest.model.Orden_Compra;
import com.apirest.model.Reserva;
import com.apirest.model.Rol;
import com.apirest.model.Usuario;
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
public class Orden_CompraDao {

    private static final Logger log = LoggerFactory.getLogger(Orden_CompraDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Variables SimpleJdbcCall de Procedimientos Almacenados    
    private SimpleJdbcCall obtener;
    private SimpleJdbcCall crear;
    private SimpleJdbcCall actualizar;
    private SimpleJdbcCall borrar;
    private SimpleJdbcCall obtenerTodo;

    // init SimpleJdbcCall
    @PostConstruct
    void init() {
        //sensitivo upcase o downcase
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        //insertar
        crear = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_CREAR_ORDEN_COMPRA");
        // Convert SYS_REFCURSOR to List
        obtener = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_ORDEN_COMPRA")
                .returningResultSet("OUT_PC_GET_ORDEN_COMPRA",
                        BeanPropertyRowMapper.newInstance(Orden_Compra.class));
        //actualizar
        actualizar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_UPD_ORDEN_COMPRA");
        //borrar
        borrar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DEL_ORDEN_COMPRA");
        obtenerTodo = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_ALL_ORDEN_COMPRA")
                .returningResultSet("OUT_PC_GET_ORDEN_COMPRA",
                        BeanPropertyRowMapper.newInstance(Orden_Compra.class));
    }

    //insertar
    public Optional crear(Orden_Compra obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_total_val_neto", obj.getTotal_val_neto())
                                                            .addValue("IN_total_val_iva", obj.getTotal_val_iva())
                                                            .addValue("IN_fecha_creacion", obj.getFecha_creacion())
                                                            .addValue("IN_fecha_gestionada", obj.getFecha_gestionada())
                                                            .addValue("IN_fecha_recepcion", obj.getFecha_recepcion())
                                                            .addValue("IN_estado", obj.getEstado());
                                                           
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
    public Integer actualizar(Orden_Compra obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_orden_compra_id", obj.getOrden_compra_id())
                                                           .addValue("IN_total_val_neto", obj.getTotal_val_neto())
                                                            .addValue("IN_total_val_iva", obj.getTotal_val_iva())
                                                            .addValue("IN_fecha_creacion", obj.getFecha_creacion())
                                                            .addValue("IN_fecha_gestionada", obj.getFecha_gestionada())
                                                            .addValue("IN_fecha_recepcion", obj.getFecha_recepcion())
                                                            .addValue("IN_estado", obj.getEstado());
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
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_orden_compra_id", id);
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
    public List<Orden_Compra> obtener(Long id) {

        log.info("SP_GET_ORDEN_COMPRA.obtener...");

        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_orden_compra_id", id);

        Map out = obtener.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_ORDEN_COMPRA");
        }
    }    
    //obtener todo
    public List<Orden_Compra> obtenerTodo() {

        log.info("SP_GET_ALL_ORDEN_COMPRA.obtenerTodo...");

        Map out = obtenerTodo.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_ORDEN_COMPRA");
        }
    }    
}
