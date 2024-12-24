package com.multibranch.app.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

public class ValidationUtils {
    public static String obtenerMensajeError(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        for (FieldError error : result.getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }
        String primerError = errores.values().iterator().next();
        return primerError;
    }
    public static boolean isValidRequest(Map<String, Integer> request, String... requiredKeys) {
        if (request == null || request.isEmpty()) {
            return false;
        }
        for (String key : requiredKeys) {
            Integer value = request.get(key);
            // Verificar solo si el valor es nulo o es un número entero igual a 0
            if (value == null || value == 0) {
                return false;
            }
        }

        return true;
    }

}
