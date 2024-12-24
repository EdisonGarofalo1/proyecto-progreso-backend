package com.multibranch.app.services.unitMeasure;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.enume.EMessage;
import com.multibranch.app.entities.request.unitMeasure.UnitMeasureSaveRequestEntity;
import com.multibranch.app.entities.request.unitMeasure.UnitMeasureUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.unitMeasure.IUnitMeasureRepository;
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
public class UnitMeasureService implements IUnitMeasureService{
    private IUnitMeasureRepository repository;
    private JdbcTemplate jdbcTemplate;

    @Override
    public TSEntity<List<Map<String, Object>>> getAllUnitMeasures() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = new TSEntity<>();
        try {
            List<Map<String, Object>>  result = this.repository.getAllUnitMeasures();
            response.setData(result);
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<Map<String, Object>> getUnitMeasureById(Map<String, Integer> request) throws DataSourceException {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        if (!isValidRequest(request, "idUnidadMedida")) {
            return buildMapErrorResponse();
        }
        try {
            int idUnidadMedida = request.get("idUnidadMedida");
            List<Map<String, Object>> result = repository.getUnitMeasureById(idUnidadMedida);
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
    public TSEntity<GenericResponseEntity> save(UnitMeasureSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.save(this.jdbcTemplate, request.getNombre(),request.getNombreCorto());
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
    public TSEntity<GenericResponseEntity> update(UnitMeasureUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.update(this.jdbcTemplate, request.getIdUnidadMedida(),
                                                                   request.getNombre(),
                                                                   request.getNombreCorto());
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
        if (!isValidRequest(request, "idUnidadMedida")) {
            return buildGenericErrorResponse();
        }
        try {
            int idUnidadMedida = request.get("idUnidadMedida");
            Map<String, Object>  result = repository.delete(this.jdbcTemplate,idUnidadMedida);
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            return buildGenericErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }
}
