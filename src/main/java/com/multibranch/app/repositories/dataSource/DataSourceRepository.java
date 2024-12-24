package com.multibranch.app.repositories.dataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.multibranch.app.entities.dataSource.EDataSource;
import com.multibranch.app.entities.dataSource.StoredProcedureEntity;
import com.multibranch.app.entities.enume.ECode;
import com.multibranch.app.exception.DataSourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DataSourceRepository  implements IDataSourceRepository{

    private static final Logger log = LoggerFactory.getLogger(DataSourceRepository.class);
    @Value("${database.type}")
    private String typeSQL;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataSourceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> execute(StoredProcedureEntity procedureEntity) throws DataSourceException {
        return this.execute(this.jdbcTemplate, procedureEntity);
    }

    public List<Map<String, Object>> execute(JdbcTemplate jdbcTemplate, StoredProcedureEntity procedureEntity) throws DataSourceException {
        try {
            return this.typeSQL.trim().equalsIgnoreCase("MySQL") ? this.executeMySQL(jdbcTemplate, procedureEntity) : this.executeSQLServer(jdbcTemplate, procedureEntity);
        } catch (DataAccessException var4) {
            DataAccessException e = var4;
            throw new DataSourceException(e, ECode.CODE_EXECUTE_DATASOURCE.getCode(), EDataSource.ERROR_EXECUTE.getMessage());
        } catch (Exception var5) {
            Exception e = var5;
            throw new DataSourceException(e, ECode.CODE_EXECUTE_DATASOURCE.getCode(), EDataSource.ERROR_EXECUTE.getMessage());
        }
    }

    private List<Map<String, Object>> executeMySQL(JdbcTemplate jdbcTemplate, StoredProcedureEntity procedureEntity) throws DataSourceException {
        String storedProcedureCall = this.getNameProcedure(procedureEntity.getName(), procedureEntity.getQuantityParams());
        Object[] params = this.getParams(procedureEntity.getListParams());
        log.info("storedProcedureCall={}", storedProcedureCall);
        log.info("params={}", params);
        return jdbcTemplate.queryForList(storedProcedureCall, params);
    }

    private List<Map<String, Object>> executeSQLServer(JdbcTemplate jdbcTemplate, StoredProcedureEntity procedureEntity) {
        StringBuilder sql = new StringBuilder("EXEC ");
        sql.append(procedureEntity.getName());
        sql.append(" ");
        List<Object> paramValues = new ArrayList();
        if (!procedureEntity.getInput().isEmpty()) {
            procedureEntity.getInput().forEach((key, value) -> {
                sql.append("@").append(key).append(" = ?, ");
                paramValues.add(value);
            });
            sql.setLength(sql.length() - 2);
        }

        log.info("storedProcedureCall={}", sql);
        log.info("params={}", paramValues);
        return jdbcTemplate.queryForList(sql.toString(), paramValues.toArray());
    }

    private String getNameProcedure(String name, Integer quantityParams) throws DataSourceException {
        try {
            String params = "(";

            for(int i = 0; i < quantityParams; ++i) {
                params = params + "?,";
            }

            if (params.length() > 1) {
                params = params.substring(0, params.length() - 1);
            }

            params = params + ")";
            return "CALL " + name + params;
        } catch (Exception var5) {
            Exception e = var5;
            throw new DataSourceException(e, ECode.CODE_EXECUTE_DATASOURCE.getCode(), EDataSource.ERROR_MAP_PARAMS.getMessage());
        }
    }

    private Object[] getParams(List<Object> list) throws DataSourceException {
        try {
            Object[] params = new Object[list.size()];

            for(int i = 0; i < list.size(); ++i) {
                params[i] = list.get(i);
            }

            return params;
        } catch (Exception var4) {
            Exception e = var4;
            throw new DataSourceException(e, ECode.CODE_EXECUTE_DATASOURCE.getCode(), EDataSource.ERROR_MAP_PARAMS.getMessage());
        }
    }


//    private static final Logger log = LoggerFactory.getLogger(DataSourceRepository.class);
//    @Value("${database.type}")
//    private String typeSQL;
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public DataSourceRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Map<String, Object>> execute(StoredProcedureEntity procedureEntity) throws DataSourceException {
//        return this.execute(this.jdbcTemplate, procedureEntity);
//    }
//
//    public List<Map<String, Object>> execute(JdbcTemplate jdbcTemplate, StoredProcedureEntity procedureEntity) throws DataSourceException {
//        try {
//            return this.typeSQL.trim().equalsIgnoreCase("MySQL") ? this.executeMySQL(jdbcTemplate, procedureEntity) : this.executeSQLServer(jdbcTemplate, procedureEntity);
//        } catch (DataAccessException var4) {
//            DataAccessException e = var4;
//            throw new DataSourceException(e, ECode.CODE_EXECUTE_DATASOURCE.getCode(), EDataSource.ERROR_EXECUTE.getMessage());
//        } catch (Exception var5) {
//            Exception e = var5;
//            throw new DataSourceException(e, ECode.CODE_EXECUTE_DATASOURCE.getCode(), EDataSource.ERROR_EXECUTE.getMessage());
//        }
//    }
//
//    private List<Map<String, Object>> executeMySQL(JdbcTemplate jdbcTemplate, StoredProcedureEntity procedureEntity) throws DataSourceException {
//        String storedProcedureCall = this.getNameProcedure(procedureEntity.getName(), procedureEntity.getQuantityParams());
//        Object[] params = this.getParams(procedureEntity.getListParams());
//        log.info("storedProcedureCall={}", storedProcedureCall);
//        log.info("params={}", params);
//        return jdbcTemplate.queryForList(storedProcedureCall, params);
//    }
//
//    private List<Map<String, Object>> executeSQLServer(JdbcTemplate jdbcTemplate, StoredProcedureEntity procedureEntity) {
//        StringBuilder sql = new StringBuilder("EXEC ");
//        sql.append(procedureEntity.getName());
//        sql.append(" ");
//        List<Object> paramValues = new ArrayList();
//        procedureEntity.getInput().forEach((key, value) -> {
//            sql.append("@").append(key).append(" = ?, ");
//            paramValues.add(value);
//        });
//        sql.setLength(sql.length() - 2);
//        log.info("storedProcedureCall={}", sql);
//        log.info("params={}", paramValues);
//        return jdbcTemplate.queryForList(sql.toString(), paramValues.toArray());
//    }
//
//    private String getNameProcedure(String name, Integer quantityParams) throws DataSourceException {
//        try {
//            String params = "(";
//
//            for(int i = 0; i < quantityParams; ++i) {
//                params = params + "?,";
//            }
//
//            if (params.length() > 1) {
//                params = params.substring(0, params.length() - 1);
//            }
//
//            params = params + ")";
//            return "CALL " + name + params;
//        } catch (Exception var5) {
//            Exception e = var5;
//            throw new DataSourceException(e, ECode.CODE_EXECUTE_DATASOURCE.getCode(), EDataSource.ERROR_MAP_PARAMS.getMessage());
//        }
//    }
//
//    private Object[] getParams(List<Object> list) throws DataSourceException {
//        try {
//            Object[] params = new Object[list.size()];
//
//            for(int i = 0; i < list.size(); ++i) {
//                params[i] = list.get(i);
//            }
//
//            return params;
//        } catch (Exception var4) {
//            Exception e = var4;
//            throw new DataSourceException(e, ECode.CODE_EXECUTE_DATASOURCE.getCode(), EDataSource.ERROR_MAP_PARAMS.getMessage());
//        }
//    }
}
