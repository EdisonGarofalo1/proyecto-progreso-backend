package com.multibranch.app.utils;

import com.multibranch.app.entities.GenericResponseEntity;
import com.multibranch.app.entities.TSEntity;
import com.multibranch.app.entities.enume.EMessage;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;

public class ResponseUtils {


    public static boolean isNotFound(List<Map<String, Object>> result) {
        return result.size() == 1 && result.get(0).containsKey("message");
    }

    // Construye una respuesta de error con un código y mensaje por defecto
    public static TSEntity<Map<String, Object>> buildMapErrorResponse() {
        return buildMapErrorResponse(EMessage.INVALIDREQUEST.getCode(), EMessage.INVALIDREQUEST.getKey());
    }
    public static TSEntity<GenericResponseEntity> buildGenericErrorResponse() {
        return buildGenericErrorResponse(EMessage.INVALIDREQUEST.getCode(), EMessage.INVALIDREQUEST.getKey());
    }

    // Construye una respuesta de error con código y mensaje personalizados
    public static TSEntity<Map<String, Object>> buildMapErrorResponse(int code, String message) {
        TSEntity<Map<String, Object>> response = new TSEntity<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public static TSEntity<GenericResponseEntity> buildGenericErrorResponse(int code, String customMessage) {
        TSEntity<GenericResponseEntity> response = new TSEntity<>();
        response.setCode(code);
        response.setMessage(customMessage);
        return response;
    }

    public static  TSEntity<GenericResponseEntity> handleValidationErrors(BindingResult result) {
        if (result.hasErrors()) {
            TSEntity<GenericResponseEntity> response = new TSEntity<>();
            String mensajeError = ValidationUtils.obtenerMensajeError(result);
            response.setCode(EMessage.VALIDACION.getCode());
            response.setMessage(mensajeError);
            return response;
        }
        return null;
    }
}
