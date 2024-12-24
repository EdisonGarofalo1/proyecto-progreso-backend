package com.multibranch.app.repositories.sales;

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
public class SalesRepository implements  ISalesRepository{
    private IDataSource dataSource;
    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, Integer id_cliente,
                                    Integer id_sucursal, Integer id_usuario, Integer id_caja,
                                    String nro_boleta, Integer tipo_pago, Integer TipoDocumento,
                                    String descripcion, BigDecimal iva, BigDecimal subtotal,
                                    BigDecimal total_venta, BigDecimal ImporteRecibido,
                                    Integer tipo_venta) throws DataSourceException {

        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_guardar_venta_producto");
        procedureEntity.addInput("p_id_cliente",id_cliente);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_id_usuario",id_usuario);
        procedureEntity.addInput("p_id_caja",id_caja);
        procedureEntity.addInput("p_nro_boleta",nro_boleta);
        procedureEntity.addInput("p_tipo_pago",tipo_pago);
        procedureEntity.addInput("p_TipoDocumento",TipoDocumento);
        procedureEntity.addInput("p_descripcion",descripcion);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subtotal);
        procedureEntity.addInput("p_total_venta",total_venta);
        procedureEntity.addInput("p_ImporteRecibido",ImporteRecibido);
        procedureEntity.addInput("p_tipo_venta",tipo_venta);

        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> saveDetail(JdbcTemplate jdbcTemplate, Integer id_venta,
                                          Integer id_usuario, Integer id_lote, Integer id_producto,
                                          Integer cantidad, BigDecimal precio_unitario,
                                          BigDecimal iva, BigDecimal subtotal, BigDecimal total) throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("sp_actualizar_venta_producto_detalle");
        procedureEntity.addInput("p_id_venta",id_venta);
        procedureEntity.addInput("p_id_usuario",id_usuario);
        procedureEntity.addInput("p_id_lote",id_lote);
        procedureEntity.addInput("p_id_producto",id_producto);
        procedureEntity.addInput("p_cantidad",cantidad);
        procedureEntity.addInput("p_precio_unitario",precio_unitario);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subtotal);
        procedureEntity.addInput("p_total",total);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_venta,
                                      Integer id_cliente,
                                      Integer id_usuario, String nro_boleta,
                                      Integer tipo_pago, Integer TipoDocumento,
                                      String descripcion, BigDecimal iva, BigDecimal subtotal,
                                      BigDecimal total_venta, BigDecimal ImporteRecibido,
                                      Integer tipo_venta) throws DataSourceException {
        StoredProcedureEntity  procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_actualizar_venta_producto");
        procedureEntity.addInput("p_id_venta",id_venta);
        procedureEntity.addInput("p_id_cliente",id_cliente);
        procedureEntity.addInput("p_id_usuario",id_usuario);
        procedureEntity.addInput("p_nro_boleta",nro_boleta);
        procedureEntity.addInput("p_tipo_pago",tipo_pago);
        procedureEntity.addInput("p_TipoDocumento",TipoDocumento);
        procedureEntity.addInput("p_descripcion",descripcion);
        procedureEntity.addInput("p_iva",iva);
        procedureEntity.addInput("p_subtotal",subtotal);
        procedureEntity.addInput("p_total_venta",total_venta);
        procedureEntity.addInput("p_ImporteRecibido",ImporteRecibido);
        procedureEntity.addInput("p_tipo_venta",tipo_venta);
        return executeStoredProcedure(jdbcTemplate,procedureEntity,dataSource);
    }
}
