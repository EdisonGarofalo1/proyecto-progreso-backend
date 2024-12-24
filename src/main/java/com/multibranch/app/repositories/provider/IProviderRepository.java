package com.multibranch.app.repositories.provider;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface IProviderRepository {
List<Map<String,Object>> getAllProviders ()throws DataSourceException;
List<Map<String,Object>> getProviderById (Integer p_id_proveedor)throws DataSourceException;
Map<String, Object> save (JdbcTemplate jdbcTemplate,String ruc,
                          String nombre,
                          String razon_social,
                          String direccion,
                          String telefono,
                          String email)throws  DataSourceException;
Map<String, Object> update (JdbcTemplate jdbcTemplate, Integer p_id_proveedor,String ruc,
                              String nombre,
                              String razon_social,
                              String direccion,
                              String telefono,
                              String email)throws  DataSourceException;
Map<String, Object> delete (JdbcTemplate jdbcTemplate, Integer p_id_proveedor)throws  DataSourceException;
}
