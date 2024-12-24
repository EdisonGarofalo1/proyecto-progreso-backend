package com.multibranch.app.repositories.client;

import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IClientRepository {
List<Map<String,Object>> getAllClients ()throws DataSourceException;
List<Map<String,Object>> getClientById (Integer id_cliente)throws DataSourceException;

Map<String,Object> save (JdbcTemplate jdbcTemplate,
                         String nombre,
                         String direccion,
                         String  telefono_1,
                         String  telefono_2,
                         String  telefono_3,
                         String  telefono_4,
                         String  correo_electronico,
                         Integer limite_credito,
                         String tipo_identificacion,
                         String numero_identificacion)throws DataSourceException;
Map<String,Object> update (JdbcTemplate jdbcTemplate,
                             Integer id_cliente,
                             String nombre,
                             String direccion,
                             String  telefono_1,
                             String  telefono_2,
                             String  telefono_3,
                             String  telefono_4,
                             String  correo_electronico,
                           Integer limite_credito,
                             String tipo_identificacion,
                             String numero_identificacion)throws DataSourceException;

Map<String,Object>delete (JdbcTemplate jdbcTemplate,Integer id_cliente)throws DataSourceException;
}
