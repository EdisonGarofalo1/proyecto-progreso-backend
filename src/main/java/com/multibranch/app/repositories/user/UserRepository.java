package com.multibranch.app.repositories.user;

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
public class UserRepository  implements  IUserRepository{
    private IDataSource dataSource;
    @Override
    public List<Map<String, Object>> getAllUsers() throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListUsuario");
        procedureEntity.addInput("p_id_usuario","");
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getUserById(Integer id_usuario) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListUsuario");
        procedureEntity.addInput("p_id_usuario",id_usuario);
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate,
                                    String numero_identificacion, String correo_electronico,
                                    String direccion, String telefono, String username,
                                    String password_hash, Integer rol, Integer id_sucursal) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarUsuario");
        procedureEntity.addInput("p_id_usuario","");
        procedureEntity.addInput("p_numero_identificacion",numero_identificacion);
        procedureEntity.addInput("p_correo_electronico",correo_electronico);
        procedureEntity.addInput("p_direccion ",direccion);
        procedureEntity.addInput("p_telefono",telefono);
        procedureEntity.addInput("p_username",username);
        procedureEntity.addInput("p_password_hash",password_hash);
        procedureEntity.addInput("p_rol",rol);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_usuario, String numero_identificacion,
                                      String correo_electronico, String direccion, String telefono, String username,
                                      String password_hash, Integer rol, Integer id_sucursal) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarUsuario");
        procedureEntity.addInput("p_id_usuario",id_usuario);
        procedureEntity.addInput("p_numero_identificacion",numero_identificacion);
        procedureEntity.addInput("p_correo_electronico",correo_electronico);
        procedureEntity.addInput("p_direccion ",direccion);
        procedureEntity.addInput("p_telefono",telefono);
        procedureEntity.addInput("p_username",username);
        procedureEntity.addInput("p_password_hash",password_hash);
        procedureEntity.addInput("p_rol",rol);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_usuario) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("");
        procedureEntity.addInput("",id_usuario);
        return  executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public List<Map<String, Object>> findByUserName(String username) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_BuscarUsuario");
        procedureEntity.addInput("p_name",username);
        return  this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> login(String username, String password) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_login");
        procedureEntity.addInput("p_username",username);
        procedureEntity.addInput("p_password",password);
        return  this.dataSource.execute(procedureEntity);
    }
}
