package com.multibranch.app.repositories.unitMeasure;

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
public class UnitMeasureRepository implements IUnitMeasureRepository {
    private IDataSource dataSource;
    @Override
    public List<Map<String, Object>> getAllUnitMeasures() throws DataSourceException {
        StoredProcedureEntity procedureEntity  = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListUnidadMedida");
        procedureEntity.addInput("p_id_unidad_medida","");
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getUnitMeasureById(Integer id_unidad_medida) throws DataSourceException {
        StoredProcedureEntity procedureEntity  = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListUnidadMedida");
        procedureEntity.addInput("p_id_unidad_medida",id_unidad_medida);
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, String nombre, String nombre_corto) throws DataSourceException {
        StoredProcedureEntity procedureEntity  = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarUnidadMedidad");
        procedureEntity.addInput("p_id_unidad_medida","");
        procedureEntity.addInput("p_nombre",nombre);
        procedureEntity.addInput("p_nombre_corto",nombre_corto);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);

    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_unidad_medida, String nombre, String nombre_corto) throws DataSourceException {
        StoredProcedureEntity procedureEntity  = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarUnidadMedidad");
        procedureEntity.addInput("p_id_unidad_medida",id_unidad_medida);
        procedureEntity.addInput("p_nombre",nombre);
        procedureEntity.addInput("p_nombre_corto",nombre_corto);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_unidad_medida) throws DataSourceException {
        StoredProcedureEntity procedureEntity  = new StoredProcedureEntity();
        procedureEntity.setName("ups_DelecteUnidadMedida");
        procedureEntity.addInput("p_id_unidad_medida",id_unidad_medida);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
