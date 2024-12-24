package com.multibranch.app.repositories.category;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface ICategoryRepository {

     List<Map<String, Object>> getAllCategories() throws DataSourceException;
     List<Map<String, Object>> getCategoryById(Integer idCategoria) throws DataSourceException;
     Map<String, Object> save(  JdbcTemplate jdbcTemplate, String name) throws DataSourceException;
     Map<String, Object> update(  JdbcTemplate jdbcTemplate,Integer idCategoria, String name) throws DataSourceException;

     Map<String, Object> delete(  JdbcTemplate jdbcTemplate,Integer idCategoria) throws DataSourceException;



}
