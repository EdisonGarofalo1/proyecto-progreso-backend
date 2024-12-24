package com.multibranch.app.services.provider;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.provider.ProviderSaveRequestEntity;
import com.multibranch.app.entities.request.provider.ProviderUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface IProviderService {
    TSEntity<List<Map<String, Object>>>  getAllProviders() throws DataSourceException;

    TSEntity<Map<String, Object>> getProviderById(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> save(ProviderSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> update(ProviderUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;

}
