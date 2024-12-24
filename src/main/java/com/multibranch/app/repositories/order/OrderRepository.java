package com.multibranch.app.repositories.order;

import com.multibranch.app.entities.dataSource.StoredProcedureEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.services.dataSource.IDataSource;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

import static com.multibranch.app.utils.StoredProcedureUtils.executeStoredProcedure;

@AllArgsConstructor
@Repository
public class OrderRepository  implements  IOrderRepository{
    private IDataSource dataSource;

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, Integer idCliente,
                                    Integer idUsuario, Integer idSucursal,
                                    BigDecimal iva, BigDecimal subtotal,
                                    BigDecimal total) throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("sp_guardar_pedido_producto");
        procedureEntity.addInput("p_id_cliente",idCliente);
        procedureEntity.addInput("p_id_usuario",idUsuario);
        procedureEntity.addInput("p_id_sucursal",idSucursal);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subtotal);
        procedureEntity.addInput("p_total",total);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> saveDetail(JdbcTemplate jdbcTemplate, Integer idPedido,
                                          Integer idProducto, Integer idLote, Integer cantidad,
                                          BigDecimal precioUnitario, BigDecimal iva,
                                          BigDecimal subTotal, BigDecimal total) throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("sp_actualizar_pedido_producto_detalle");
        procedureEntity.addInput("p_id_pedido",idPedido);
        procedureEntity.addInput("p_id_producto",idProducto);
        procedureEntity.addInput("p_id_lote",idLote);
        procedureEntity.addInput("p_cantidad",cantidad);
        procedureEntity.addInput("p_precio_unitario",precioUnitario);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subTotal);
        procedureEntity.addInput("p_total",total);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);

    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer idPedido, Integer idCliente, Integer idUsuario, Integer idSucursal, BigDecimal iva, BigDecimal subtotal, BigDecimal total) throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("sp_actualizar_pedido_producto");
        procedureEntity.addInput("p_id_pedido",idPedido);
        procedureEntity.addInput("p_id_usuario",idUsuario);
        procedureEntity.addInput("p_id_cliente",idCliente);
        procedureEntity.addInput("p_id_sucursal",idSucursal);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subtotal);
        procedureEntity.addInput("p_total",total);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);


    }


}
