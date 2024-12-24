package com.multibranch.app.repositories.cash;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface ICashRepository {
List<Map<String, Object>> getAllCashs() throws DataSourceException;

List<Map<String, Object>> getCashById(Integer id_caja) throws DataSourceException;

Map<String, Object> save (JdbcTemplate jdbcTemplate,
                          Integer id_sucursal,
                          Integer numero_caja,
                          String folio,
                          String nombre_caja,
                          String ubicacion)throws DataSourceException;
    Map<String, Object> update (JdbcTemplate jdbcTemplate,
                              Integer id_caja,
                              Integer id_sucursal,
                              Integer numero_caja,
                              String folio,
                              String nombre_caja,
                              String ubicacion)throws DataSourceException;

Map<String,Object> delete (JdbcTemplate jdbcTemplate,
                           Integer id_caja)throws DataSourceException;
}
