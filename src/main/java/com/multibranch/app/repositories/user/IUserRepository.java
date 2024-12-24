package com.multibranch.app.repositories.user;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface IUserRepository {
    List<Map<String, Object>> getAllUsers()throws DataSourceException;
    List<Map<String, Object>> getUserById(Integer id_usuario)throws DataSourceException;

    Map<String, Object> save (JdbcTemplate jdbcTemplate,String numero_identificacion,
                              String correo_electronico, String direccion, String telefono,
                              String username, String password_hash, Integer rol,
                              Integer id_sucursal) throws DataSourceException;

    Map<String, Object> update (JdbcTemplate jdbcTemplate,Integer id_usuario,String numero_identificacion,
                              String correo_electronico, String direccion, String telefono,
                              String username, String password_hash, Integer rol,
                              Integer id_sucursal) throws DataSourceException;
    Map<String, Object> delete (JdbcTemplate jdbcTemplate,Integer id_usuario)throws DataSourceException;

    List<Map<String, Object>> findByUserName(String username)throws DataSourceException;
    List<Map<String, Object>> login(String username, String password)throws DataSourceException;
}
