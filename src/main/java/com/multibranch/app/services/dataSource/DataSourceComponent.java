package com.multibranch.app.services.dataSource;

import com.multibranch.app.entities.dataSource.StoredProcedureEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.dataSource.IDataSourceRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class DataSourceComponent implements IDataSource {
    private IDataSourceRepository repository;

    public List<Map<String, Object>> execute(String name, Object... params) throws DataSourceException {
        return this.repository.execute(this.mapper(name, params));
    }

    public List<Map<String, Object>> execute(StoredProcedureEntity procedureEntity) throws DataSourceException {
        return this.repository.execute(procedureEntity);
    }




    public List<Map<String, Object>> execute(JdbcTemplate jdbcTemplate, String name, Object... params) throws DataSourceException {
        return this.repository.execute(jdbcTemplate, this.mapper(name, params));
    }

    public List<Map<String, Object>> execute(JdbcTemplate jdbcTemplate, StoredProcedureEntity procedureEntity) throws DataSourceException {
        return this.repository.execute(jdbcTemplate, procedureEntity);
    }

    private StoredProcedureEntity mapper(String name, Object... params) {
        StoredProcedureEntity entity = new StoredProcedureEntity(name);
        entity.setListParams(Arrays.asList(params));
        entity.setQuantityParams(params.length);
        return entity;
    }

    public DataSourceComponent(IDataSourceRepository repository) {
        this.repository = repository;
    }
}
