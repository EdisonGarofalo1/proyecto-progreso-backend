package com.multibranch.app.repositories.product;

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
public class ProductRepository  implements IProductRepository{

private IDataSource dataSource;

    @Override
    public List<Map<String, Object>> getAllProducts() throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListProducto");
        procedureEntity.addInput("p_id_producto","");
        return this.dataSource.execute(procedureEntity);
    }

    @Override
    public List<Map<String, Object>> getProductById(Integer id_producto) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ListProducto");
        procedureEntity.addInput("p_id_producto",id_producto);
        return this.dataSource.execute(procedureEntity);
    }

    @Override
    public Map<String, Object> save(JdbcTemplate jdbcTemplate, Integer id_categoria,
                                    Integer id_marca, Integer id_unidad_medida, String nombre, String img,
                                    Integer lleva_iva, Integer inventariable, Integer perecedero) throws DataSourceException {

        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarActualizarProducto");
        procedureEntity.addInput("p_id_producto","");
        procedureEntity.addInput("p_id_marca",id_marca);
        procedureEntity.addInput("p_id_unidad_medida",id_unidad_medida);
        procedureEntity.addInput("p_id_categoria",id_categoria);
        procedureEntity.addInput("p_nombre",nombre);
        procedureEntity.addInput("p_img",img);
        procedureEntity.addInput("p_lleva_iva",lleva_iva);
        procedureEntity.addInput("p_inventariable",inventariable);
        procedureEntity.addInput("p_perecedero",perecedero);
        return executeStoredProcedure( jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> update(JdbcTemplate jdbcTemplate, Integer id_producto, Integer id_categoria, Integer id_marca, Integer id_unidad_medida, String nombre, String img, Integer lleva_iva, Integer inventariable, Integer perecedero) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_GuardarActualizarProducto");
        procedureEntity.addInput("p_id_producto",id_producto);
        procedureEntity.addInput("p_id_categoria",id_categoria);
        procedureEntity.addInput("p_id_marca",id_marca);
        procedureEntity.addInput("p_id_unidad_medid",id_unidad_medida);
        procedureEntity.addInput("p_nombre",nombre);
        procedureEntity.addInput("p_img",img);
        procedureEntity.addInput("p_lleva_iva",lleva_iva);
        procedureEntity.addInput("p_inventariable",inventariable);
        procedureEntity.addInput("p_perecedero",perecedero);
        return executeStoredProcedure( jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> delete(JdbcTemplate jdbcTemplate, Integer id_producto) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("ups_DelecteProducto");
        procedureEntity.addInput("p_id_producto",id_producto);
        return executeStoredProcedure( jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> saveProductLote(JdbcTemplate jdbcTemplate, Integer id_sucursal,
                                                   Integer id_producto, String codigo_barra, String fecha_vencimiento,
                                                   Integer cantidad, BigDecimal precio_venta, BigDecimal precio_compra,
                                                   BigDecimal precio_1, BigDecimal precio_2, Integer id_usuario,
                                                   String concepto) throws DataSourceException {

        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_InsertarLoteProducto");
        procedureEntity.addInput("p_id_producto",id_producto);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_fecha_vencimiento",fecha_vencimiento);
        procedureEntity.addInput("p_codigo_barra",codigo_barra);
        procedureEntity.addInput("p_cantidad",cantidad);
        procedureEntity.addInput("p_precio_venta",precio_venta);
        procedureEntity.addInput("P_precio_compra",precio_compra);
        procedureEntity.addInput("p_precio_1",precio_1);
        procedureEntity.addInput("p_precio_2",precio_2);
        procedureEntity.addInput("p_id_usuario",id_usuario);
        procedureEntity.addInput("p_concepto",concepto);
        return executeStoredProcedure( jdbcTemplate,procedureEntity,dataSource);
    }

    @Override
    public Map<String, Object> updateProductLote(JdbcTemplate jdbcTemplate, Integer id_lote,
                                                      Integer id_sucursal, Integer id_producto, String codigo_barra,
                                                      String fecha_vencimiento, Integer cantidad, BigDecimal precio_venta,
                                                      BigDecimal precio_compra, BigDecimal precio_1, BigDecimal
                                                      precio_2, Integer id_usuario) throws DataSourceException {
        StoredProcedureEntity procedureEntity = new StoredProcedureEntity();
        procedureEntity.setName("usp_ActualizarLoteProducto");
        procedureEntity.addInput("p_id_lote",id_lote);
        procedureEntity.addInput("p_id_sucursal",id_sucursal);
        procedureEntity.addInput("p_id_producto",id_producto);
        procedureEntity.addInput("p_codigo_barra",codigo_barra);
        procedureEntity.addInput("p_fecha_vencimiento",fecha_vencimiento);
        procedureEntity.addInput("p_cantidad",cantidad);
        procedureEntity.addInput("p_precio_venta",precio_venta);
        procedureEntity.addInput("P_precio_compra",precio_compra);
        procedureEntity.addInput("p_precio_1",precio_1);
        procedureEntity.addInput("p_precio_2",precio_2);
        procedureEntity.addInput("p_id_usuario",id_usuario);
        return executeStoredProcedure( jdbcTemplate,procedureEntity,dataSource);
    }

}
