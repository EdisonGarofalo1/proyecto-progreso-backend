package com.multibranch.app.repositories.unitMeasure;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface IUnitMeasureRepository {

    List<Map< String, Object >> getAllUnitMeasures() throws DataSourceException;
    List<Map< String, Object >> getUnitMeasureById(Integer id_unidad_medida) throws DataSourceException;

    Map<String, Object> save (JdbcTemplate jdbcTemplate,
                              String nombre,
                              String nombre_corto) throws DataSourceException;
    Map<String, Object> update (JdbcTemplate jdbcTemplate,
                              Integer id_unidad_medida,
                              String nombre,
                              String nombre_corto) throws DataSourceException;


    Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_unidad_medida)throws DataSourceException;


}
