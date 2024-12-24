package com.multibranch.app.repositories.branch;

import com.multibranch.app.entities.dataSource.StoredProcedureEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.services.dataSource.IDataSource;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.multibranch.app.utils.StoredProcedureUtils.executeStoredProcedure;

@AllArgsConstructor
@Repository
public class BranchRepository implements IBranchRepository {
   private IDataSource dataSource;

    @Override
    public List<Map<String, Object>> getAllBranchs() throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("usp_ListSucursal");
        procedureEntity.addInput("p_id_sucursal","");
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getBranchsById(Integer id_sucursal) throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("usp_ListSucursal");
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate,
                                    String nombre, String direccion, Integer id_centro,
                                    String razon_social, String ruc, String mensaje,
                                    String marca, String serie_boleta,
                                    BigDecimal impuesto, String email,
                                    String telefono) throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarSucursal");
        procedureEntity.addInput("p_id_sucursal","");
        procedureEntity.addInput("p_nombre",nombre);
        procedureEntity.addInput("p_direccion",direccion);
        procedureEntity.addInput("p_id_centro",id_centro);
        procedureEntity.addInput("p_razon_social",razon_social);
        procedureEntity.addInput("p_ruc",ruc);
        procedureEntity.addInput("p_mensaje",mensaje);
        procedureEntity.addInput("p_marca",marca);
        procedureEntity.addInput("p_serie_boleta",serie_boleta);
        procedureEntity.addInput("p_impuesto",impuesto);
        procedureEntity.addInput("p_email",email);
        procedureEntity.addInput("p_telefono",telefono);
      return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_sucursal,
                                      String nombre, String direccion, Integer id_centro,
                                      String razon_social, String ruc, String mensaje,
                                      String marca, String serie_boleta, BigDecimal impuesto,
                                      String email, String telefono) throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarSucursal");
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_nombre",nombre);
        procedureEntity.addInput("p_direccion",direccion);
        procedureEntity.addInput("p_id_centro",id_centro);
        procedureEntity.addInput("p_razon_social",razon_social);
        procedureEntity.addInput("p_ruc",ruc);
        procedureEntity.addInput("p_mensaje",mensaje);
        procedureEntity.addInput("p_marca",marca);
        procedureEntity.addInput("p_serie_boleta",serie_boleta);
        procedureEntity.addInput("p_impuesto",impuesto);
        procedureEntity.addInput("p_email",email);
        procedureEntity.addInput("p_telefono",telefono);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }


    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_sucursal) throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("ups_DelecteSucursal");
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
