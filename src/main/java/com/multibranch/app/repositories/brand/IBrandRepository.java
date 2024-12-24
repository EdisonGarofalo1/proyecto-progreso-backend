package com.multibranch.app.repositories.brand;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface IBrandRepository {

    List<Map< String , Object >> getAllBrans() throws DataSourceException;
    List<Map< String , Object >> getBranById(Integer id_marca) throws DataSourceException;

    Map< String, Object> save ( JdbcTemplate jdbcTemplate,
                                String nombre)throws DataSourceException;
    Map< String, Object> update ( JdbcTemplate jdbcTemplate,
                                Integer id_marca,
                                String nombre)throws DataSourceException;

    Map<String , Object> delete (JdbcTemplate jdbcTemplate,Integer id_marca)throws DataSourceException;
}
