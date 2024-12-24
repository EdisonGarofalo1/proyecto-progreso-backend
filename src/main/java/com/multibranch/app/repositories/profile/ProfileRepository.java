package com.multibranch.app.repositories.profile;

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
public class ProfileRepository  implements IProfileRepository{
    private IDataSource dataSource;
    @Override
    public List<Map<String, Object>> getAllProfiles() throws DataSourceException {
        StoredProcedureEntity procedureEntity= new StoredProcedureEntity();
        procedureEntity.setName("usp_ListPerfil");
        procedureEntity.addInput("p_id_perfi","");
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getProfileById(Integer id_perfil) throws DataSourceException {
        StoredProcedureEntity procedureEntity= new StoredProcedureEntity();
        procedureEntity.setName("usp_ListPerfil");
        procedureEntity.addInput("p_id_perfi",id_perfil);
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, String descripcion) throws DataSourceException {
        StoredProcedureEntity procedureEntity= new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarPerfil");
        procedureEntity.addInput("p_id_perfil","");
        procedureEntity.addInput("p_descripcion",descripcion);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_perfil, String descripcion) throws DataSourceException {
        StoredProcedureEntity procedureEntity= new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarPerfil");
        procedureEntity.addInput("p_id_perfil",id_perfil);
        procedureEntity.addInput("p_descripcion",descripcion);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_perfil) throws DataSourceException {
        StoredProcedureEntity procedureEntity= new StoredProcedureEntity();
        procedureEntity.setName("ups_DelectePerfil");
        procedureEntity.addInput("p_id_perfil",id_perfil);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
