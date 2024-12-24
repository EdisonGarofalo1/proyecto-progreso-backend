package com.multibranch.app.services.brand;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.brand.BrandSaveRequestEntity;
import com.multibranch.app.entities.request.brand.BrandUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface IBrandService {
    TSEntity<List<Map<String, Object>>>  getAllBrans() throws DataSourceException;

    TSEntity<Map<String, Object>> getBranById(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> save(BrandSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> update(BrandUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;

}
