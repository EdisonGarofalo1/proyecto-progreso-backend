package com.multibranch.app.repositories.product;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IProductRepository {
    List<Map<String,Object>> getAllProducts()throws DataSourceException;
    List<Map<String,Object>> getProductById(Integer id_producto)throws DataSourceException;

    Map<String,Object> save (JdbcTemplate jdbcTemplate,
                             Integer id_categoria,
                             Integer id_marca,
                             Integer id_unidad_medida,
                             String nombre,
                             String img,
                             Integer lleva_iva,
                             Integer inventariable,
                             Integer perecedero)throws DataSourceException;
    Map<String,Object> update (JdbcTemplate jdbcTemplate,
                             Integer id_producto,
                             Integer id_categoria,
                             Integer id_marca,
                             Integer id_unidad_medida,
                             String nombre,
                             String img,
                             Integer lleva_iva,
                             Integer inventariable,
                             Integer perecedero)throws DataSourceException;

    Map<String,Object>delete (JdbcTemplate jdbcTemplate, Integer id_producto )throws DataSourceException;

    Map<String,Object>saveProductLote (JdbcTemplate jdbcTemplate ,Integer id_sucursal ,
                                           Integer id_producto , String codigo_barra , String fecha_vencimiento ,
                                           Integer cantidad , BigDecimal precio_venta , BigDecimal precio_compra ,
                                           BigDecimal precio_1 , BigDecimal precio_2 , Integer id_usuario ,
                                           String concepto )throws DataSourceException;

    Map<String,Object>updateProductLote (JdbcTemplate jdbcTemplate,  Integer id_lote,Integer id_sucursal ,
                                           Integer id_producto , String codigo_barra , String fecha_vencimiento ,
                                           Integer cantidad , BigDecimal precio_venta , BigDecimal precio_compra ,
                                           BigDecimal precio_1 , BigDecimal precio_2 , Integer id_usuario
                                         )throws DataSourceException;
}
