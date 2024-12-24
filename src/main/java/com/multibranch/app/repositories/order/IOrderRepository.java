package com.multibranch.app.repositories.order;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.Map;

public interface IOrderRepository {

Map<String, Object> save (JdbcTemplate jdbcTemplate,Integer idCliente,
                                                    Integer idUsuario,
                                                    Integer idSucursal,
                                                    BigDecimal iva,
                                                    BigDecimal subtotal,
                                                     BigDecimal total) throws DataSourceException;

    Map<String, Object> saveDetail (JdbcTemplate jdbcTemplate,
                                    Integer idPedido,
                                    Integer idProducto,
                                    Integer idLote,
                                    Integer cantidad,
                                    BigDecimal precioUnitario,
                                    BigDecimal iva,
                                    BigDecimal subTotal,
                                    BigDecimal total
                                    ) throws DataSourceException;

    Map<String, Object> update (JdbcTemplate jdbcTemplate, Integer idPedido ,
                                Integer idCliente,
                                Integer idUsuario,
                                Integer idSucursal,
                                BigDecimal iva,
                                BigDecimal subtotal,
                                BigDecimal total) throws DataSourceException;


}
