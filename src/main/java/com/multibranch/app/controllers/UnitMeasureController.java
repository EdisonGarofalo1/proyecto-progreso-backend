package com.multibranch.app.controllers;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.unitMeasure.UnitMeasureSaveRequestEntity;
import com.multibranch.app.entities.request.unitMeasure.UnitMeasureUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.services.unitMeasure.IUnitMeasureService;
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
@RequestMapping("/unitMeasure")
public class UnitMeasureController {
    private IUnitMeasureService service;
    @PostMapping("/list")
    public ResponseEntity<TSEntity<List<Map<String, Object>>>> getAllUnitMeasures() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = this.service.getAllUnitMeasures();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/getById")
    public ResponseEntity<TSEntity<Map<String, Object>>> getUnitMeasureById (@RequestBody Map<String, Integer> requestBody) throws DataSourceException{
        TSEntity<Map<String, Object>> response = this.service.getUnitMeasureById(requestBody);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/save")
    public ResponseEntity<TSEntity<GenericResponseEntity>> save(@Valid @RequestBody UnitMeasureSaveRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.save(body,bindingResult));
    }

    @PostMapping("/update")
    public ResponseEntity<TSEntity<GenericResponseEntity>> update(@Valid @RequestBody UnitMeasureUpdateRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.update(body,bindingResult));
    }

    @PostMapping("/delete")
    public ResponseEntity<TSEntity<GenericResponseEntity>> delete(@RequestBody Map<String, Integer> request) throws DataSourceException {
        return ResponseEntity.ok(this.service.delete(request));
    }
}

