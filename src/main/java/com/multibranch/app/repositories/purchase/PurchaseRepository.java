package com.multibranch.app.repositories.purchase;

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
public class PurchaseRepository  implements  IPurchaseRepository{
    private IDataSource dataSource;
    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, Integer idProveedor,
                                    Integer idUsuario, Integer id_sucursal, BigDecimal iva,
                                    BigDecimal subtotal, BigDecimal total) throws DataSourceException {
        StoredProcedureEntity procedureEntity =  new StoredProcedureEntity();
        procedureEntity.setName("usp_guardar_compra_producto");
        procedureEntity.addInput("p_id_proveedor",idProveedor);
        procedureEntity.addInput("p_id_usuario",idUsuario);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subtotal);
        procedureEntity.addInput("p_total",total);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> saveDetail(JdbcTemplate jdbcTemplate, Integer id_compra,
                                          Integer id_usuario, Integer id_sucursal, Integer id_lote,
                                          Integer id_producto, String codigo_barra, Integer cantidad,
                                          BigDecimal precio_compra, BigDecimal precio_venta,
                                          BigDecimal iva, BigDecimal subtotal, BigDecimal total,
                                          BigDecimal precio_1, BigDecimal precio_2,
                                          String fecha_vencimiento) throws DataSourceException {
        StoredProcedureEntity procedureEntity =  new StoredProcedureEntity();
        procedureEntity.setName("sp_actualizar_compra_producto_detalle");
        procedureEntity.addInput("p_id_compra",id_compra);
        procedureEntity.addInput("p_id_usuario",id_usuario);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_id_lote",id_lote);
        procedureEntity.addInput("p_id_producto",id_producto);
        procedureEntity.addInput("p_codigo_barra",codigo_barra);
        procedureEntity.addInput("p_cantidad",cantidad);
        procedureEntity.addInput("p_precio_compra",precio_compra);
        procedureEntity.addInput("p_precio_venta",precio_venta);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subtotal);
        procedureEntity.addInput("p_total",total);
        procedureEntity.addInput("p_precio_1",precio_1);
        procedureEntity.addInput("p_precio_2",precio_2);
        procedureEntity.addInput("p_fecha_vencimiento",fecha_vencimiento);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> Update(JdbcTemplate jdbcTemplate, Integer idCompra, Integer idProveedor,
                                      Integer idUsuario, Integer id_sucursal, BigDecimal iva,
                                      BigDecimal subtotal, BigDecimal total) throws DataSourceException {
        StoredProcedureEntity procedureEntity =  new StoredProcedureEntity();
        procedureEntity.setName("usp_actualizar_compra_producto");
        procedureEntity.addInput("p_id_compra",idCompra);
        procedureEntity.addInput("p_id_proveedor",idProveedor);
        procedureEntity.addInput("p_id_usuario",idUsuario);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subtotal);
        procedureEntity.addInput("p_subtotal",total);

        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
