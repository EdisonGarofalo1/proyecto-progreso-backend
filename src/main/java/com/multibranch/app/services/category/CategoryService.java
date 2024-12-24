package com.multibranch.app.services.category;
import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.enume.EMessage;
import com.multibranch.app.entities.request.category.CategorySaveRequestEntity;
import com.multibranch.app.entities.request.category.CategoryUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.repositories.category.ICategoryRepository;
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
public class CategoryService implements ICategoryService {

    private ICategoryRepository repository;
    private JdbcTemplate jdbcTemplate;

    @Override
    public TSEntity<List<Map<String, Object>>> getAllCategories()  {
        TSEntity<List<Map<String, Object>>> response = new TSEntity<>();
        try {
           List<Map<String, Object>>  result = this.repository.getAllCategories();
            response.setData(result);
        } catch (DataSourceException e) {
            response.setCode(e.getCode());
            response.setMessage(e.getPersonalizedMessage());
        }
        return response;
    }

    @Override
    public TSEntity<Map<String, Object>> getCategoryById(Map<String, Integer> request) {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        if (!isValidRequest(request, "idCategoria")) {
            return buildMapErrorResponse();
        }
        try {
            int idCategoria = request.get("idCategoria");
            List<Map<String, Object>> result = repository.getCategoryById(idCategoria);
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
    public TSEntity<GenericResponseEntity> save(CategorySaveRequestEntity request, BindingResult bindingResult) {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        try {
            Map<String, Object> result = this.repository.save(this.jdbcTemplate, request.getNombreCategoria());
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
    public TSEntity<GenericResponseEntity> update(CategoryUpdateRequestEntity request , BindingResult bindingResult) {
        TSEntity<GenericResponseEntity> errorResponse = handleValidationErrors(bindingResult);
        if (errorResponse != null) {
            return errorResponse;
        }
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        try {
            Map<String, Object> result = this.repository.update(this.jdbcTemplate, request.getIdCategoria(),
                    request.getNombreCategoria());

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
    public TSEntity<GenericResponseEntity> delete(Map<String, Integer> request)  {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        if (!isValidRequest(request, "idCategoria")) {
            return buildGenericErrorResponse();
        }
        try {
            int idCategoria = request.get("idCategoria");
            Map<String, Object>  result = repository.delete(this.jdbcTemplate,idCategoria);
            if (result.containsKey("message")) {
                response.setMessage((String) result.get("message"));
            }
        } catch (DataSourceException e) {
            return buildGenericErrorResponse(e.getCode(), e.getPersonalizedMessage());
        }
        return response;
    }


}
