package com.apirest.dao;

import com.apirest.model.Boleta;
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
public class BoletaDao {

    private static final Logger log = LoggerFactory.getLogger(BoletaDao.class);

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
        crear = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_CREAR_BOLETA");
        // Convert SYS_REFCURSOR to List
        obtener = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_BOLETA")
                .returningResultSet("OUT_PC_GET_BOLETA",
                        BeanPropertyRowMapper.newInstance(Boleta.class));
        //actualizar
        actualizar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_UPD_BOLETA");
        //borrar
        borrar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DEL_BOLETA");
    }

    //insertar
    public Optional crear(Boleta obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_USUARIO_ID", obj.getUsuario_id())
                                                           .addValue("IN_ORDER_MESA_ID", obj.getOrden_mesa_id())
                                                            .addValue("IN_FECHA", obj.getFecha())
                                                            .addValue("IN_TOTAL_NETO", obj.getTotal_neto())
                                                            .addValue("IN_TOTAL_IVA", obj.getTotal_iva())
                                                            .addValue("IN_TIPO_PAGO", obj.getTipo_pago());
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
    public Integer actualizar(Boleta obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_BOLETA_ID", obj.getBoleta_id())
                                                           .addValue("IN_USUARIO_ID", obj.getUsuario_id())
                                                           .addValue("IN_ORDER_MESA_ID", obj.getOrden_mesa_id())
                                                            .addValue("IN_FECHA", obj.getFecha())
                                                            .addValue("IN_TOTAL_NETO", obj.getTotal_neto())
                                                            .addValue("IN_TOTAL_IVA", obj.getTotal_iva())
                                                            .addValue("IN_TIPO_PAGO", obj.getTipo_pago());
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
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_BOLETA_ID", id);
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
    public List<Boleta> obtener(Long id) {

        log.info("SP_GET_BOLETA.obtener...");

        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_BOLETA_ID", id);

        Map out = obtener.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_BOLETA");
        }
    }    
}
