package com.multibranch.app.repositories.category;
import com.multibranch.app.entities.dataSource.StoredProcedureEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.services.dataSource.IDataSource;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

import static com.multibranch.app.utils.StoredProcedureUtils.executeStoredProcedure;

@AllArgsConstructor
@Repository
public class CategoryRepository  implements ICategoryRepository {

    private IDataSource dataSource;

    @Override
    public List<Map<String, Object>> getAllCategories() throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListCategoria");
        procedureEntity.addInput("p_id_categoria", "");
        return this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getCategoryById(Integer idCategoria) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListCategoria");
        procedureEntity.addInput("p_id_categoria", idCategoria);
        return this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, String name) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarActualizarCategoria");
        procedureEntity.addInput("p_id_categoria", "");
        procedureEntity.addInput("p_nombre", name);
        return executeStoredProcedure(jdbcTemplate, procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer idCategoria, String name) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarActualizarCategoria");
        procedureEntity.addInput("p_id_categoria",idCategoria);
        procedureEntity.addInput("p_nombre", name);
        return executeStoredProcedure(jdbcTemplate, procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer idCategoria) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("ups_DelecteCategoria");
        procedureEntity.addInput("p_id_categoria", idCategoria);
        return executeStoredProcedure(jdbcTemplate, procedureEntity,dataSource);
    }


}
