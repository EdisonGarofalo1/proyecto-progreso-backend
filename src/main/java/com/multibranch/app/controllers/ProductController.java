package com.multibranch.app.controllers;
import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;

import com.multibranch.app.entities.request.product.ProductSaveRequestEntity;
import com.multibranch.app.entities.request.product.ProductUpdateRequestEntity;
import com.multibranch.app.entities.request.product.SaveProductLoteRequestEntity;
import com.multibranch.app.entities.request.product.UpdateProductLoteRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.services.product.IProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {
    private IProductService service;

    @PostMapping("/list")
    public ResponseEntity<TSEntity<List<Map<String, Object>>>> getAllProducts() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = this.service.getAllProducts();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/getById")
    public ResponseEntity<TSEntity<Map<String, Object>>> getProductById (@RequestBody Map<String, Integer> requestBody) throws DataSourceException{
        TSEntity<Map<String, Object>> response = this.service.getProductById(requestBody);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<TSEntity<GenericResponseEntity>> save(@Valid @RequestBody ProductSaveRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.save(body,bindingResult));
    }

    @PostMapping("/update")
    public ResponseEntity<TSEntity<GenericResponseEntity>> update(@Valid @RequestBody ProductUpdateRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.update(body,bindingResult));
    }

    @PostMapping("/delete")
    public ResponseEntity<TSEntity<GenericResponseEntity>> delete(@RequestBody Map<String, Integer> request) throws DataSourceException {
        return ResponseEntity.ok(this.service.delete(request));
    }

    @PostMapping("/saveProductLote")
    public ResponseEntity<TSEntity<GenericResponseEntity>> saveProductLote(@Valid @RequestBody SaveProductLoteRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.saveProductLote(body,bindingResult));
    }

    @PostMapping("/updateProductLote")
    public ResponseEntity<TSEntity<GenericResponseEntity>> updateProductLote(@Valid @RequestBody UpdateProductLoteRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.updateProductLote(body,bindingResult));
    }

}
