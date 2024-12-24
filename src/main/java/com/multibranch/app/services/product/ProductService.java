package com.multibranch.app.services.product;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.enume.EMessage;
import com.multibranch.app.entities.request.product.ProductSaveRequestEntity;
import com.multibranch.app.entities.request.product.ProductUpdateRequestEntity;
import com.multibranch.app.entities.request.product.SaveProductLoteRequestEntity;
import com.multibranch.app.entities.request.product.UpdateProductLoteRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.product.IProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import java.util.List;
import java.util.Map;
import static com.multibranch.app.utils.ResponseUtils.*;
import static com.multibranch.app.utils.ValidationUtils.isValidRequest;

@AllArgsConstructor
@Service
public class ProductService implements  IProductService {

    private IProductRepository repository;
    private JdbcTemplate jdbcTemplate;
    @Override
    public TSEntity<List<Map<String, Object>>> getAllProducts()  {
        TSEntity<List<Map<String, Object>>> response = new TSEntity<>();
        try {
            List<Map<String, Object>>  result = this.repository.getAllProducts();
            response.setData(result);
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<Map<String, Object>> getProductById(Map<String, Integer> request)  {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        if (!isValidRequest(request, "idProducto")) {
            return buildMapErrorResponse();
        }
        try {
            int idProducto = request.get("idProducto");
            List<Map<String, Object>> result = repository.getProductById(idProducto);
            if (isNotFound(result)) {
                return buildMapErrorResponse(EMessage.NOTFOUND.getCode(), (String) result.getFirst().get("message"));
            }
            response.setData(result.getFirst());
        } catch (DataSourceException e) {
            return buildMapErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<GenericResponseEntity> save(ProductSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.save(this.jdbcTemplate, request.getIdCategoria(),
                    request.getIdMarca(),request.getIdUnidadMedida(),request.getNombre(),
                    request.getImg(),request.getLlevaIva(),request.getInventariable(),
                    request.getPerecedero());

            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<GenericResponseEntity> update(ProductUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.update(this.jdbcTemplate, request.getIdProducto(),request.getIdCategoria(),
                    request.getIdMarca(),request.getIdUnidadMedida(),request.getNombre(),
                    request.getImg(),request.getLlevaIva(),request.getInventariable(),
                    request.getPerecedero());

            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        if (isValidRequest(request)) {
            return buildGenericErrorResponse();
        }

        try {
            int idProducto = request.get("idProducto");
            Map<String, Object>  result = repository.delete(this.jdbcTemplate,idProducto);
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            return buildGenericErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<GenericResponseEntity> saveProductLote(SaveProductLoteRequestEntity request,BindingResult bindingResult)  {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.saveProductLote(this.jdbcTemplate, request.getIdSucursal(),
                    request.getId_producto(),request.getCodigo_barra(),request.getFecha_vencimiento(),
                    request.getCantidad(),request.getPrecio_venta(),request.getPrecio_compra(),
                    request.getPrecio_1(),request.getPrecio_2(),request.getId_usuario(),request.getConcepto());

            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<GenericResponseEntity> updateProductLote(UpdateProductLoteRequestEntity request,BindingResult bindingResult)  {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.updateProductLote(this.jdbcTemplate, request.getIdLote(),
                    request.getIdSucursal(),request.getId_producto(),request.getCodigo_barra(),request.getFecha_vencimiento(),
                    request.getCantidad(),request.getPrecio_venta(),request.getPrecio_compra(),
                    request.getPrecio_1(),request.getPrecio_2(),request.getId_usuario());

            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }
}
