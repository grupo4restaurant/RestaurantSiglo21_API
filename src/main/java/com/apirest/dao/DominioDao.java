package com.apirest.dao;

import com.apirest.model.Dominio;
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
public class DominioDao {

    private static final Logger log = LoggerFactory.getLogger(DominioDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Variables SimpleJdbcCall de Procedimientos Almacenados    
    private SimpleJdbcCall obtener;
    private SimpleJdbcCall crear;
    private SimpleJdbcCall actualizar;
    private SimpleJdbcCall borrar;

    // init SimpleJdbcCall
    @PostConstruct
    void init() {
        //sensitivo upcase o downcase
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        //insertar
        crear = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_CREAR_DOMINIO");
        // Convert SYS_REFCURSOR to List
        obtener = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_DOMINIO")
                .returningResultSet("OUT_PC_GET_DOMINIO",
                        BeanPropertyRowMapper.newInstance(Dominio.class));
        //actualizar
        actualizar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_UPD_DOMINIO");
        //borrar
        borrar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DEL_DOMINIO");
    }

    //insertar
    public Optional crear(Dominio obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_DOM_VAL_DOM", obj.getDom_val_dom())
                                                           .addValue("IN_DOM_DESC", obj.getDom_desc())
                                                            .addValue("IN_DOM_VAL", obj.getDom_val())
                                                            .addValue("IN_DOM_ESTADO", obj.getDom_estado());
                                                            
                                                            
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
    public Integer actualizar(Dominio obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_DOM_ID", obj.getDom_id())
                                                           .addValue("IN_DOM_VAL_DOM", obj.getDom_val_dom())
                                                           .addValue("IN_DOM_DESC", obj.getDom_desc())
                                                            .addValue("IN_DOM_VAL", obj.getDom_val())
                                                            .addValue("IN_DOM_ESTADO", obj.getDom_estado());
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
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_DOM_ID", id);
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
    public List<Dominio> obtener(Long id) {

        log.info("SP_GET_DOMINIO.obtener...");

        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_DOM_ID", id);

        Map out = obtener.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_DOMINIO");
        }
    }    
}
