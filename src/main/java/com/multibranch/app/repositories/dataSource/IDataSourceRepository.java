package com.multibranch.app.repositories.dataSource;

import com.multibranch.app.entities.dataSource.StoredProcedureEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public interface IDataSourceRepository {
    List<Map<String, Object>> execute(StoredProcedureEntity var1) throws DataSourceException;

    List<Map<String, Object>> execute(JdbcTemplate var1, StoredProcedureEntity var2) throws DataSourceException;
}
