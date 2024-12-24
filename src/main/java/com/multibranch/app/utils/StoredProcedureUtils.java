package com.multibranch.app.utils;

import com.multibranch.app.entities.dataSource.StoredProcedureEntity;
import com.multibranch.app.entities.enume.ECode;
import com.multibranch.app.exception.DataSourceException;

import com.multibranch.app.services.dataSource.IDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;

public class StoredProcedureUtils {

    public static Map<String, Object> executeStoredProcedure(JdbcTemplate jdbcTemplate, StoredProcedureEntity procedureEntity, IDataSource dataSource) throws DataSourceException {
        List<Map<String, Object>> result = dataSource.execute(jdbcTemplate, procedureEntity);
        Map<String, Object> firstResult = result.stream().findFirst()
                .orElseThrow(() -> new DataSourceException(ECode.CODE_EXECUTE_DATASOURCE.getCode(), "No results found"));
        String message = (String) firstResult.get("message");
        if (message != null && message.contains("error")) {
            throw new DataSourceException(ECode.CODE_EXECUTE_DATASOURCE.getCode(), message);
        }
        return firstResult;
    }
}
