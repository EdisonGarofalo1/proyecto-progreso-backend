package com.multibranch.app.services.product;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.product.ProductSaveRequestEntity;
import com.multibranch.app.entities.request.product.ProductUpdateRequestEntity;
import com.multibranch.app.entities.request.product.SaveProductLoteRequestEntity;
import com.multibranch.app.entities.request.product.UpdateProductLoteRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public interface IProductService {

    TSEntity<List<Map<String, Object>>> getAllProducts() throws DataSourceException;

    TSEntity<Map<String, Object>> getProductById(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> save(ProductSaveRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> update(ProductUpdateRequestEntity request, BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> delete(Map<String, Integer> request) throws DataSourceException;

    TSEntity<GenericResponseEntity> saveProductLote(SaveProductLoteRequestEntity request,BindingResult bindingResult) throws DataSourceException;

    TSEntity<GenericResponseEntity> updateProductLote(UpdateProductLoteRequestEntity request,BindingResult bindingResult) throws DataSourceException;





}
