package com.apirest.dao;

import com.apirest.model.Producto;
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
public class ProductoDao {

    private static final Logger log = LoggerFactory.getLogger(ProductoDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //Variables SimpleJdbcCall de Procedimientos Almacenados    
    private SimpleJdbcCall obtener;
    private SimpleJdbcCall crear;
    private SimpleJdbcCall actualizar;
    private SimpleJdbcCall borrar;
    private SimpleJdbcCall obtenerPorCategoria;

    // init SimpleJdbcCall
    @PostConstruct
    void init() {
        //sensitivo upcase o downcase
        jdbcTemplate.setResultsMapCaseInsensitive(true);
        //insertar
        crear = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_CREAR_PRODUCTO");
        // Convert SYS_REFCURSOR to List
        obtener = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_PRODUCTO")
                .returningResultSet("OUT_PC_GET_PRODUCTO",
                        BeanPropertyRowMapper.newInstance(Producto.class));
        obtenerPorCategoria = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("SP_GET_PRODUCTO_BY_IDCATEGORIA")
                .returningResultSet("OUT_PC_GET_PRODUCTO",
                        BeanPropertyRowMapper.newInstance(Producto.class));
        //actualizar
        actualizar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_UPD_PRODUCTO");
        //borrar
        borrar = new SimpleJdbcCall(jdbcTemplate).withProcedureName("SP_DEL_PRODUCTO");
    }

    //insertar
    public Optional crear(Producto obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_cat_prod_id", obj.getCat_prod_id())
                                                           .addValue("IN_proveedor_id", obj.getProveedor_id())
                                                            .addValue("IN_nombre", obj.getNombre())
                                                            .addValue("IN_cod", obj.getCod())
                                                            .addValue("IN_valor_neto", obj.getValor_neto());
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
    public Optional actualizar(Producto obj){
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_producto_id", obj.getProducto_id())
                                                           .addValue("IN_cat_prod_id", obj.getCat_prod_id())
                                                           .addValue("IN_proveedor_id", obj.getProveedor_id())
                                                            .addValue("IN_nombre", obj.getNombre())
                                                            .addValue("IN_cod", obj.getCod())
                                                            .addValue("IN_valor_neto", obj.getValor_neto());
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
        SqlParameterSource in = new MapSqlParameterSource().addValue("IN_producto_id", id);
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
    
    //obtener por id
    public List<Producto> obtener(Long id) {

        log.info("SP_GET_PRODUCTO.obtener...");

        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_producto_id", id);

        Map out = obtener.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_PRODUCTO");
        }
    }    
    
    //obtener POR CATEGORIA
    public List<Producto> obtenerPorCategoria(Long id) {

        log.info("SP_GET_PRODUCTO_BY_IDCATEGORIA.obtenerPorCategoria...");
        
        SqlParameterSource paramaters = new MapSqlParameterSource().addValue("IN_CAT_PROD_ID", id);

        Map out = obtenerPorCategoria.execute(paramaters);

        if (out == null) {
            return Collections.emptyList();
        } else {
            return (List) out.get("OUT_PC_GET_PRODUCTO");
        }
    }    
}
