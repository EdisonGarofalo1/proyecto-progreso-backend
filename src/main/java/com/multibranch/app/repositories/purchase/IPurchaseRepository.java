package com.multibranch.app.repositories.purchase;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Map;

public interface IPurchaseRepository {

    Map<String,Object> save (JdbcTemplate jdbcTemplate, Integer idProveedor ,
                             Integer idUsuario ,
                             Integer id_sucursal ,
                             BigDecimal iva ,
                             BigDecimal subtotal ,
                             BigDecimal total )throws DataSourceException;

    Map<String, Object> saveDetail (JdbcTemplate jdbcTemplate,
                                    Integer id_compra  ,
                                    Integer id_usuario ,
                                    Integer id_sucursal ,
                                    Integer id_lote ,
                                    Integer id_producto ,
                                    String codigo_barra ,
                                    Integer cantidad ,
                                    BigDecimal precio_compra ,
                                    BigDecimal precio_venta ,
                                    BigDecimal iva ,
                                    BigDecimal subtotal ,
                                    BigDecimal total ,
                                    BigDecimal precio_1 ,
                                    BigDecimal precio_2 ,
                                    String fecha_vencimiento ) throws DataSourceException;

    Map<String,Object> Update (JdbcTemplate jdbcTemplate, Integer idCompra,
                             Integer idProveedor ,
                             Integer idUsuario ,
                             Integer id_sucursal ,
                             BigDecimal iva ,
                             BigDecimal subtotal ,
                             BigDecimal total )throws DataSourceException;

}
