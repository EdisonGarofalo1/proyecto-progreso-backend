package com.multibranch.app.controllers;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.request.client.ClientSaveRequestEntity;
import com.multibranch.app.entities.request.client.ClientUpdateRequestEntity;
import com.multibranch.app.exception.DataSourceException;
import com.multibranch.app.services.client.IClientService;
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
@RequestMapping("/client")
public class ClientController {
    private  IClientService service;
    @PostMapping("/list")
    public ResponseEntity<TSEntity<List<Map<String, Object>>>> getAllClients() throws DataSourceException {
        TSEntity<List<Map<String, Object>>> response = this.service.getAllClients();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/getById")
    public ResponseEntity<TSEntity<Map<String, Object>>> getClientById (@RequestBody Map<String, Integer> requestBody) throws DataSourceException{
        TSEntity<Map<String, Object>> response = this.service.getClientById(requestBody);
        return ResponseEntity.ok(response);
    }
    @PostMapping("/save")
    public ResponseEntity<TSEntity<GenericResponseEntity>> save(@Valid @RequestBody ClientSaveRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.save(body,bindingResult));
    }

    @PostMapping("/update")
    public ResponseEntity<TSEntity<GenericResponseEntity>> update(@Valid @RequestBody ClientUpdateRequestEntity body , BindingResult bindingResult) throws DataSourceException {
        return ResponseEntity.ok(this.service.update(body,bindingResult));
    }

    @PostMapping("/delete")
    public ResponseEntity<TSEntity<GenericResponseEntity>> delete(@RequestBody Map<String, Integer> request) throws DataSourceException {
        return ResponseEntity.ok(this.service.delete(request));
    }
}
