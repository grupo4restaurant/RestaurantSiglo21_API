package com.apirest.dao;

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
public class UsuarioDao {

    private static final Logger log = LoggerFactory.getLogger(UsuarioDao.class);

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
        crear = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_CREAR_USUARIO");
        // Convert SYS_REFCURSOR to List
        obtener = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_USUARIO")
                .returningResultSet("OUT_PC_GET_USUARIO",
                        BeanPropertyRowMapper.newInstance(Usuario.class));
        //actualizar
        actualizar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_UPD_USUARIO");
        //borrar
        borrar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DEL_USUARIO");
    }

    //insertar
    public Optional crear(Usuario obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_ROL_ID", obj.getRol_id())
                                                           .addValue("IN_NOMBRE", obj.getNombre())
                                                            .addValue("IN_AP_PATERNO", obj.getAp_paterno())
                                                            .addValue("IN_AP_MATERNO", obj.getAp_materno())
                                                            .addValue("IN_E_MAIL", obj.getE_mail())
                                                            .addValue("IN_FONO", obj.getFono());
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
    //obtener
    public List<Usuario> obtener(Long id) {

        log.info("SP_GET_USUARIO.obtener...");

        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_USUARIO_ID", id);

        Map out = obtener.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_USUARIO");
        }
    }    
    //actualizar
    public Optional actualizar(Usuario obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_USUARIO_ID", obj.getUsuario_id())
                                                           .addValue("IN_ROL_ID", obj.getRol_id())
                                                           .addValue("IN_NOMBRE", obj.getNombre())
                                                            .addValue("IN_AP_PATERNO", obj.getAp_paterno())
                                                            .addValue("IN_AP_MATERNO", obj.getAp_materno())
                                                            .addValue("IN_E_MAIL", obj.getE_mail())
                                                            .addValue("IN_FONO", obj.getFono());
        Optional result = Optional.empty();
        
        try{
            Map out = actualizar.execute(in);
            if (out != null){
                String OUT_ID_SALIDA = (String) out.get("OUT_GLOSA");
                BigDecimal OUT_ESTADO = (BigDecimal) out.get("OUT_ESTADO");
                
                result = Optional.of(OUT_ESTADO);
            }
        }catch(Exception e){
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
        }
        return result;
    }
    //borrar
    public Optional borrar(Long id){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_USUARIO_ID", id);
        Optional result = Optional.empty();
        
        try{
            Map out = borrar.execute(in);
            if (out != null){
                String OUT_ID_SALIDA = (String) out.get("OUT_GLOSA");
                BigDecimal OUT_ESTADO = (BigDecimal) out.get("OUT_ESTADO");
                
                result = Optional.of(OUT_ESTADO);
            }
        }catch(Exception e){
            // ORA-01403: no data found, or any java.sql.SQLException
            System.err.println(e.getMessage());
        }
        return result;
    }
}
