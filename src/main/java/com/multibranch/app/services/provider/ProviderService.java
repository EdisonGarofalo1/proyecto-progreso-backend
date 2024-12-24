package com.multibranch.app.services.provider;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.enume.EMessage;
import com.multibranch.app.entities.request.provider.ProviderSaveRequestEntity;
import com.multibranch.app.entities.request.provider.ProviderUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.provider.IProviderRepository;
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
public class ProviderService implements IProviderService{
    private IProviderRepository repository;
    private JdbcTemplate jdbcTemplate;

    @Override
    public TSEntity<List<Map<String, Object>>> getAllProviders() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = new TSEntity<>();
        try {
            List<Map<String, Object>>  result = this.repository.getAllProviders();
            response.setData(result);
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<Map<String, Object>> getProviderById(Map<String, Integer> request) throws DataSourceException {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        if (!isValidRequest(request, "idProveedor")) {
            return buildMapErrorResponse();
        }
        try {
            int idProveedor = request.get("idProveedor");
            List<Map<String, Object>> result = repository.getProviderById(idProveedor);
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
    public TSEntity<GenericResponseEntity> save(ProviderSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.save(this.jdbcTemplate, request.getRuc(),request.getNombre(),
                                                        request.getRazonSocial(),request.getDireccion(),
                                                       request.getTelefono(),request.getEmail()
                                                       );
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
    public TSEntity<GenericResponseEntity> update(ProviderUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.update(this.jdbcTemplate,request.getIdProveedor() ,
                    request.getRuc(),request.getNombre(),
                    request.getRazonSocial(),request.getDireccion(),
                    request.getTelefono(),request.getEmail());
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
        if (!isValidRequest(request, "idProveedor")) {
            return buildGenericErrorResponse();
        }
        try {
            int idProveedor = request.get("idProveedor");
            Map<String, Object>  result = repository.delete(this.jdbcTemplate,idProveedor);
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            return buildGenericErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }
}
