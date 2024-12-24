package com.multibranch.app.services.unitMeasure;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.unitMeasure.UnitMeasureSaveRequestEntity;
import com.multibranch.app.entities.request.unitMeasure.UnitMeasureUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface IUnitMeasureService {
    TSEntity<List<Map<String, Object>>>  getAllUnitMeasures() throws DataSourceException;

    TSEntity<Map<String, Object>> getUnitMeasureById(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> save(UnitMeasureSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> update(UnitMeasureUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;

}
