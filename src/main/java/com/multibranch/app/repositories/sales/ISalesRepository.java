package com.multibranch.app.repositories.sales;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Map;

public interface ISalesRepository {
   Map<String,Object>save (JdbcTemplate jdbcTemplate,
                           Integer id_cliente ,
                           Integer id_sucursal ,
                           Integer id_usuario ,
                           Integer id_caja ,
                           String nro_boleta ,
                           Integer tipo_pago ,
                           Integer TipoDocumento ,
                           String descripcion ,
                           BigDecimal iva ,
                           BigDecimal subtotal ,
                           BigDecimal total_venta ,
                           BigDecimal ImporteRecibido,
                           Integer tipo_venta )throws DataSourceException;

    Map<String, Object> saveDetail (JdbcTemplate jdbcTemplate,
                                    Integer id_venta ,
                                    Integer id_usuario ,
                                    Integer id_lote ,
                                    Integer id_producto ,
                                    Integer cantidad ,
                                    BigDecimal precio_unitario ,
                                    BigDecimal iva ,
                                    BigDecimal subtotal ,
                                    BigDecimal total  ) throws DataSourceException;

    Map<String,Object>update (JdbcTemplate jdbcTemplate,
                            Integer id_venta,
                            Integer id_cliente ,
                            Integer id_usuario ,
                            String nro_boleta ,
                            Integer tipo_pago ,
                            Integer TipoDocumento ,
                            String descripcion ,
                            BigDecimal iva ,
                            BigDecimal subtotal ,
                            BigDecimal total_venta ,
                            BigDecimal ImporteRecibido,
                            Integer tipo_venta )throws DataSourceException;

}
