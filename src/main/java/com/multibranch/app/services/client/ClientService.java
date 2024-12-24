package com.multibranch.app.services.client;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.enume.EMessage;
import com.multibranch.app.entities.request.client.ClientSaveRequestEntity;
import com.multibranch.app.entities.request.client.ClientUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.client.IClientRepository;
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
public class ClientService implements IClientService{
    private IClientRepository repository;
    private JdbcTemplate jdbcTemplate;

    @Override
    public TSEntity<List<Map<String, Object>>> getAllClients() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = new TSEntity<>();
        try {
            List<Map<String, Object>>  result = this.repository.getAllClients();
            response.setData(result);
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<Map<String, Object>> getClientById(Map<String, Integer> request) throws DataSourceException {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        if (!isValidRequest(request, "idCliente")) {
            return buildMapErrorResponse();
        }
        try {
            int idCliente = request.get("idCliente");
            List<Map<String, Object>> result = repository.getClientById(idCliente);
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
    public TSEntity<GenericResponseEntity> save(ClientSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.save(this.jdbcTemplate, request.getNombre(),request.getDireccion(),
                                  request.getTelefono_1(),request.getTelefono_2(),request.getTelefono_3(),request.getTelefono_4(),
                                 request.getCorreo_electronico(),request.getLimiteCredito(),request.getTipoIdentificacion(),
                                 request.getNumeroIdentificacion());
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
    public TSEntity<GenericResponseEntity> update(ClientUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.update(this.jdbcTemplate,request.getIdCliente(), request.getNombre(),request.getDireccion(),
                    request.getTelefono_1(),request.getTelefono_2(),request.getTelefono_3(),request.getTelefono_4(),
                    request.getCorreo_electronico(),request.getLimiteCredito(),request.getTipoIdentificacion(),
                    request.getNumeroIdentificacion());
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
        if (!isValidRequest(request, "idCliente")) {
            return buildGenericErrorResponse();
        }
        try {
            int idCliente = request.get("idCliente");
            Map<String, Object>  result = repository.delete(this.jdbcTemplate,idCliente);
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            return buildGenericErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }
}
