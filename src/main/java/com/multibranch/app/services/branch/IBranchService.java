package com.multibranch.app.services.branch;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.branch.BranchSaveRequestEntity;
import com.multibranch.app.entities.request.branch.BranchUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface IBranchService {
    TSEntity<List<Map<String, Object>>>  getAllCategories() throws DataSourceException;

    TSEntity<Map<String, Object>> getCategoryById(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> save(BranchSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> update(BranchUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;

}
