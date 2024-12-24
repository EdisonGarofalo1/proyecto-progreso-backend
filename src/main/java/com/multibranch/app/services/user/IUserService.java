package com.multibranch.app.services.user;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.category.CategorySaveRequestEntity;
import com.multibranch.app.entities.request.category.CategoryUpdateRequestEntity;
import com.multibranch.app.entities.request.user.UserSaveRequestEntity;
import com.multibranch.app.entities.request.user.UserUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface IUserService {
    TSEntity<List<Map<String, Object>>> getAllUsers() throws DataSourceException;

    TSEntity<Map<String, Object>> getUserById(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> save(UserSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> update(UserUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;

    TSEntity<Map<String, Object>> login(UserSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;


}
