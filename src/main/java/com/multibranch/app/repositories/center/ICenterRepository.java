package com.multibranch.app.repositories.center;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface ICenterRepository {

    List<Map<String, Object>> getAllCenters ()throws DataSourceException;
    List<Map<String, Object>> getCenterById (Integer id_centro)throws DataSourceException;

    Map<String,Object> save(JdbcTemplate jdbcTemplate, String desc_centro,
                                  String estado,
                            String estado_centro,
                            String abreviatura )throws DataSourceException;
    Map<String,Object> update(JdbcTemplate jdbcTemplate,Integer id_centro, String desc_centro,
                            String estado,
                            String estado_centro,
                            String abreviatura )throws DataSourceException;


    Map<String,Object> delete( JdbcTemplate jdbcTemplate,Integer id_centro)throws DataSourceException;


}
