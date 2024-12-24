package com.multibranch.app.repositories.profile;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface IProfileRepository {
    List<Map<String, Object>> getAllProfiles()throws DataSourceException;
    List<Map<String, Object>> getProfileById(Integer id_perfil)throws DataSourceException;
    Map<String ,Object> save (JdbcTemplate jdbcTemplate ,String descripcion)throws DataSourceException;
    Map<String ,Object> update (JdbcTemplate jdbcTemplate ,Integer id_perfil,String descripcion)throws DataSourceException;

    Map<String ,Object> delete (JdbcTemplate jdbcTemplate,Integer id_perfil)throws DataSourceException;
}
