package com.apirest.dao;

import com.apirest.model.Proveedor;
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
public class ProveedorDao {

    private static final Logger log = LoggerFactory.getLogger(ProveedorDao.class);

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
        crear = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_CREAR_PROVEEDOR");
        // Convert SYS_REFCURSOR to List
        obtener = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_PROVEEDOR")
                .returningResultSet("OUT_PC_GET_PROVEEDOR",
                        BeanPropertyRowMapper.newInstance(Proveedor.class));
        //actualizar
        actualizar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_UPD_PROVEEDOR");
        //borrar
        borrar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DEL_PROVEEDOR");
        //obtener todo
        obtenerTodo = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_ALL_PROVEEDOR")
                .returningResultSet("OUT_PC_GET_PROVEEDOR",
                        BeanPropertyRowMapper.newInstance(Proveedor.class));
    }

    //insertar
    public Optional crear(Proveedor obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_nombre", obj.getNombre())
                                                           .addValue("IN_fono", obj.getFono())
                                                            .addValue("IN_contacto", obj.getContacto())
                                                            .addValue("IN_e_mail", obj.getE_mail())
                                                            .addValue("IN_direccion", obj.getDireccion())
                                                            .addValue("IN_comuna", obj.getComuna());
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
    public Integer actualizar(Proveedor obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_proveedor_id", obj.getProveedor_id())
                                                           .addValue("IN_nombre", obj.getNombre())
                                                           .addValue("IN_fono", obj.getFono())
                                                            .addValue("IN_contacto", obj.getContacto())
                                                            .addValue("IN_e_mail", obj.getE_mail())
                                                            .addValue("IN_direccion", obj.getDireccion())
                                                            .addValue("IN_comuna", obj.getComuna());
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
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_proveedor_id", id);
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
    public List<Proveedor> obtener(Long id) {

        log.info("SP_GET_PROVEEDOR.obtener...");

        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_proveedor_id", id);

        Map out = obtener.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_PROVEEDOR");
        }
    }    
    //obtener todo
    public List<Proveedor> obtenerTodo() {

        log.info("SP_GET_ALL_PROVEEDOR.obtenerTodo...");

        
        Map out = obtenerTodo.execute();

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_PROVEEDOR");
        }
    }    
}
