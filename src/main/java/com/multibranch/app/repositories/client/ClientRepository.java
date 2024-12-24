package com.multibranch.app.repositories.client;
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
public class ClientRepository implements IClientRepository{
    private IDataSource dataSource;
    @Override
    public List<Map<String, Object>> getAllClients() throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("usp_ListCliente");
        procedureEntity.addInput("p_id_cliente","");
        return this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getClientById(Integer id_cliente) throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("usp_ListCliente");
        procedureEntity.addInput("p_id_cliente",id_cliente);
        return this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate,
                                    String nombre, String direccion,
                                    String telefono_1, String telefono_2, String telefono_3,
                                    String telefono_4, String correo_electronico,
                                    Integer limite_credito, String tipo_identificacion,
                                    String numero_identificacion) throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarCliente");
        procedureEntity.addInput("p_id_cliente","");
        procedureEntity.addInput("p_nombre",nombre);
        procedureEntity.addInput("p_direccion",direccion);
        procedureEntity.addInput("p_telefono_1",telefono_1);
        procedureEntity.addInput("p_telefono_2",telefono_2);
        procedureEntity.addInput("p_telefono_3",telefono_3);
        procedureEntity.addInput("p_telefono_4",telefono_4);
        procedureEntity.addInput("p_correo_electronico",correo_electronico);
        procedureEntity.addInput("p_limite_credito",limite_credito);
        procedureEntity.addInput("p_tipo_identificacion",tipo_identificacion);
        procedureEntity.addInput("p_numero_identificacion",numero_identificacion);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_cliente,
                                      String nombre, String direccion, String telefono_1,
                                      String telefono_2, String telefono_3, String telefono_4,
                                      String correo_electronico, Integer limite_credito,
                                      String tipo_identificacion,
                                      String numero_identificacion) throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarCliente");
        procedureEntity.addInput("p_id_cliente",id_cliente);
        procedureEntity.addInput("p_nombre",nombre);
        procedureEntity.addInput("p_direccion",direccion);
        procedureEntity.addInput("p_telefono_1",telefono_1);
        procedureEntity.addInput("p_telefono_2",telefono_2);
        procedureEntity.addInput("p_telefono_3",telefono_3);
        procedureEntity.addInput("p_telefono_4",telefono_4);
        procedureEntity.addInput("p_correo_electronico",correo_electronico);
        procedureEntity.addInput("p_limite_credito",limite_credito);
        procedureEntity.addInput("p_tipo_identificacion",tipo_identificacion);
        procedureEntity.addInput("p_numero_identificacion",numero_identificacion);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_cliente) throws DataSourceException {
        StoredProcedureEntity procedureEntity =new StoredProcedureEntity();
        procedureEntity.setName("ups_DelecteCliente");
        procedureEntity.addInput("p_id_cliente",id_cliente);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
