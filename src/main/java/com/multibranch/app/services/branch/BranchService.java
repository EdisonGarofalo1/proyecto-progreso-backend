package com.multibranch.app.services.branch;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.branch.BranchSaveRequestEntity;
import com.multibranch.app.entities.request.branch.BranchUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public class BranchService implements  IBranchService{
    @Override
    public TSEntity<List<Map<String, Object>>> getAllCategories() throws DataSourceException {
        return null;
    }

    @Override
    public TSEntity<Map<String, Object>> getCategoryById(Map<String, Integer> request) throws DataSourceException {
        return null;
    }

    @Override
    public TSEntity<GenericResponseEntity> save(BranchSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        return null;
    }

    @Override
    public TSEntity<GenericResponseEntity> update(BranchUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException {
        return null;
    }

    @Override
    public TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException {
        return null;
    }
}
