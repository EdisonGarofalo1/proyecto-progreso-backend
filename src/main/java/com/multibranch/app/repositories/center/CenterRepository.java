package com.multibranch.app.repositories.center;

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
public class CenterRepository implements ICenterRepository{
    private IDataSource dataSource;
    @Override
    public List<Map<String, Object>> getAllCenters() throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListCentro");
        procedureEntity.addInput("p_id_centro","");
        return this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getCenterById(Integer id_centro) throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListCentro");
        procedureEntity.addInput("p_id_centro",id_centro);
        return this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate,String desc_centro,
                                    String estado, String estado_centro,
                                    String abreviatura) throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarCentro");
        procedureEntity.addInput("p_id_centro","");
        procedureEntity.addInput("p_desc_centro",desc_centro);
        procedureEntity.addInput("p_estado",estado);
        procedureEntity.addInput("p_estado_centro",estado_centro);
        procedureEntity.addInput("p_abreviatura",abreviatura);
    return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_centro, String desc_centro, String estado, String estado_centro, String abreviatura) throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarCentro");
        procedureEntity.addInput("p_id_centro",id_centro);
        procedureEntity.addInput("p_desc_centro",desc_centro);
        procedureEntity.addInput("p_estado",estado);
        procedureEntity.addInput("p_estado_centro",estado_centro);
        procedureEntity.addInput("p_abreviatura",abreviatura);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_centro) throws DataSourceException {

        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("ups_DelecteCentro");
        procedureEntity.addInput("p_id_centro",id_centro);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
