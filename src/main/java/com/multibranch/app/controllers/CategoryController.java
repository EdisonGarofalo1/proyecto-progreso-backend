package com.multibranch.app.controllers;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.category.CategorySaveRequestEntity;
import com.multibranch.app.entities.request.category.CategoryUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.services.category.ICategoryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {

    private ICategoryService service;

    @PostMapping("/list")
    public ResponseEntity<TSEntity<List<Map<String, Object>>>> getAllCategories() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = this.service.getAllCategories();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/getById")
     public ResponseEntity<TSEntity<Map<String, Object>>> getCategoryById (@RequestBody Map<String, Integer> requestBody) throws DataSourceException{
        TSEntity<Map<String, Object>> response = this.service.getCategoryById(requestBody);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/save")
    public ResponseEntity<TSEntity<GenericResponseEntity>> save(@Valid @RequestBody CategorySaveRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.save(body,bindingResult));
    }

    @PostMapping("/update")
    public ResponseEntity<TSEntity<GenericResponseEntity>> update(@Valid @RequestBody CategoryUpdateRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.update(body,bindingResult));
    }

    @PostMapping("/delete")
    public ResponseEntity<TSEntity<GenericResponseEntity>> delete(@RequestBody Map<String, Integer> request) throws DataSourceException {
        return ResponseEntity.ok(this.service.delete(request));
    }

}
