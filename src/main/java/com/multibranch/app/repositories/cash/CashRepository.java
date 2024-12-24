package com.multibranch.app.repositories.cash;

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
public class CashRepository implements ICashRepository{
    private IDataSource dataSource;
    @Override
    public List<Map<String, Object>> getAllCashs() throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListCaja");
        procedureEntity.addInput("p_id_caja","");
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getCashById(Integer id_caja) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListCaja");
        procedureEntity.addInput("p_id_caja",id_caja);
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, Integer id_sucursal,
                                    Integer numero_caja, String folio, String nombre_caja,
                                    String ubicacion) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarCaja");
        procedureEntity.addInput("p_id_caja","");
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_numero_caja",numero_caja);
        procedureEntity.addInput("p_folio",folio);
        procedureEntity.addInput("p_nombre_caja",nombre_caja);
        procedureEntity.addInput("p_ubicacion",ubicacion);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);

    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_caja, Integer id_sucursal, Integer numero_caja, String folio, String nombre_caja, String ubicacion) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarCaja");
        procedureEntity.addInput("p_id_caja",id_caja);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_numero_caja",numero_caja);
        procedureEntity.addInput("p_folio",folio);
        procedureEntity.addInput("p_nombre_caja",nombre_caja);
        procedureEntity.addInput("p_ubicacion",ubicacion);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_caja) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("ups_DelecteCaja");
        procedureEntity.addInput("p_id_caja",id_caja);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
