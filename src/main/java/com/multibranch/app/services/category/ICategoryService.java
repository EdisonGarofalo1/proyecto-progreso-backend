package com.multibranch.app.services.category;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.category.CategorySaveRequestEntity;
import com.multibranch.app.entities.request.category.CategoryUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface ICategoryService {


TSEntity<List<Map<String, Object>>>  getAllCategories() throws DataSourceException;

TSEntity<Map<String, Object>> getCategoryById(Map<String, Integer> request) throws DataSourceException;

TSEntity<GenericResponseEntity> save(CategorySaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

TSEntity<GenericResponseEntity> update(CategoryUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;


}
