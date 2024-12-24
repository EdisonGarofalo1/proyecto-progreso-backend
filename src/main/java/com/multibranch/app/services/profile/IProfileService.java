package com.multibranch.app.services.profile;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.profile.ProfileSaveRequestEntity;
import com.multibranch.app.entities.request.profile.ProfileUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface IProfileService {
    TSEntity<List<Map<String, Object>>> getAllProfiles() throws DataSourceException;

    TSEntity<Map<String, Object>> getProfileById(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> save(ProfileSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> update(ProfileUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;


}
