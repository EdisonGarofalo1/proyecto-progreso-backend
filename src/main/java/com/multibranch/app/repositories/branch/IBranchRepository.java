package com.multibranch.app.repositories.branch;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IBranchRepository {
    List<Map<String,Object>> getAllBranchs ()throws DataSourceException;
    List<Map<String,Object>> getBranchsById (Integer id_sucursal)throws DataSourceException;

    Map<String, Object> save (JdbcTemplate jdbcTemplate,
                              String nombre,
                              String direccion,
                              Integer id_centro,
                              String razon_social,
                              String ruc,
                              String mensaje,
                              String marca,
                              String serie_boleta,
                              BigDecimal impuesto,
                              String email,
                                String telefono
    )throws DataSourceException;
    Map<String, Object> update (JdbcTemplate jdbcTemplate, Integer id_sucursal,
                              String nombre,
                              String direccion,
                              Integer id_centro,
                              String razon_social,
                              String ruc,
                              String mensaje,
                              String marca,
                              String serie_boleta,
                              BigDecimal impuesto,
                              String email,
                              String telefono
    )throws DataSourceException;

    Map<String , Object> delete (JdbcTemplate jdbcTemplate, Integer id_sucursal)throws DataSourceException;

}
