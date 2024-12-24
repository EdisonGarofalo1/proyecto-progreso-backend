package com.multibranch.app.repositories.brand;

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
public class BrandRepository implements IBrandRepository {
    private IDataSource  dataSource;

    @Override
    public List<Map<String, Object>> getAllBrans() throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListMarca");
        procedureEntity.addInput("p_id_marca","");
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getBranById(Integer id_marca) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListMarca");
        procedureEntity.addInput("p_id_marca",id_marca);
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, String nombre) throws DataSourceException {
       StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
       procedureEntity.setName("usp_GuardarMarca");
       procedureEntity.addInput("p_id_marca","");
       procedureEntity.addInput("p_nombre",nombre);
       return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_marca, String nombre) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarMarca");
        procedureEntity.addInput("p_id_marca",id_marca);
        procedureEntity.addInput("p_nombre",nombre);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_marca) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("ups_DelecteMarca");
        procedureEntity.addInput("p_id_marca",id_marca);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
