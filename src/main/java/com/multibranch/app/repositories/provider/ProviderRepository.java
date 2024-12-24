package com.multibranch.app.repositories.provider;

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
public class ProviderRepository implements IProviderRepository{
    private IDataSource dataSource;

    @Override
    public List<Map<String, Object>> getAllProviders() throws DataSourceException {
        return List.of();
    }

    @Override
    public List<Map<String, Object>> getProviderById(Integer p_id_proveedor) throws DataSourceException {
        return List.of();
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, String ruc, String nombre, String razon_social, String direccion, String telefono, String email) throws DataSourceException {
        return Map.of();
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer p_id_proveedor, String ruc, String nombre, String razon_social, String direccion, String telefono, String email) throws DataSourceException {
        return Map.of();
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer p_id_proveedor) throws DataSourceException {
        return Map.of();
    }
//    @Override
//    public List<Map<String, Object>> getAllProviders(Integer p_id_proveedor) throws DataSourceException {
//        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
//        procedureEntity.setName("usp_ListProveedor");
//        procedureEntity.addInput("p_id_proveedor",p_id_proveedor);
//        return this.dataSource.execute(procedureEntity);
//    }
//
//    @Override
//    public Map<String, Object> save(JdbcTemplate jdbcTemplate, Integer p_id_proveedor, String ruc,
//                                    String nombre, String razon_social, String direccion,
//                                    String telefono, String email) throws DataSourceException {
//        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
//        procedureEntity.setName("usp_GuardarProveedor");
//        procedureEntity.addInput("p_id_proveedor",p_id_proveedor);
//        procedureEntity.addInput("p_ruc",ruc);
//        procedureEntity.addInput("p_nombre",nombre);
//        procedureEntity.addInput("p_razon_social",razon_social);
//        procedureEntity.addInput("p_direccion",direccion);
//        procedureEntity.addInput("p_telefono",telefono);
//        procedureEntity.addInput("p_email",email);
//
//     return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
//
//    }
//
//    @Override
//    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer p_id_proveedor) throws DataSourceException {
//        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
//        procedureEntity.setName("ups_DelecteProveedor");
//        procedureEntity.addInput("p_id_proveedor",p_id_proveedor);
//        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
//    }
}
