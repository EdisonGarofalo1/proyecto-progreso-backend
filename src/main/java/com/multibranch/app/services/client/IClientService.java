package com.multibranch.app.services.client;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.client.ClientSaveRequestEntity;
import com.multibranch.app.entities.request.client.ClientUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface IClientService {
    TSEntity<List<Map<String, Object>>>  getAllClients() throws DataSourceException;

    TSEntity<Map<String, Object>> getClientById(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> save(ClientSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> update(ClientUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;

}
