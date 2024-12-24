package com.multibranch.app.services.brand;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.enume.EMessage;
import com.multibranch.app.entities.request.brand.BrandSaveRequestEntity;
import com.multibranch.app.entities.request.brand.BrandUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.brand.IBrandRepository;
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
public class BrandService implements IBrandService{
    private IBrandRepository repository;
    private JdbcTemplate jdbcTemplate;

    @Override
    public TSEntity<List<Map<String, Object>>> getAllBrans() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = new TSEntity<>();
        try {
            List<Map<String, Object>>  result = this.repository.getAllBrans();
            response.setData(result);
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<Map<String, Object>> getBranById(Map<String, Integer> request) throws DataSourceException {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        if (!isValidRequest(request, "idMarca")) {
            return buildMapErrorResponse();
        }
        try {
            int idMarca = request.get("idMarca");
            List<Map<String, Object>> result = repository.getBranById(idMarca);
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
    public TSEntity<GenericResponseEntity> save(BrandSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.save(this.jdbcTemplate, request.getNombre());
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
    public TSEntity<GenericResponseEntity> update(BrandUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.update(this.jdbcTemplate, request.getIdMarca(),request.getNombre());
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
        if (!isValidRequest(request, "idMarca")) {
            return buildGenericErrorResponse();
        }
        try {
            int idMarca = request.get("idMarca");
            Map<String, Object>  result = repository.delete(this.jdbcTemplate,idMarca);
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            return buildGenericErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }
}
