package com.multibranch.app.entities.enume;

public enum EMessage {
    OK("El proceso se realizó con éxito.", 200),
    CREATED("Creación exitosa.", 201),
    UPDATED("Actualización exitosa.", 200),
    DELETED("Eliminación exitosa.", 200),
    CHECKREQUEST("Dato erróneo enviado, revisa y vuelve a intentar.", 422),
    INVALIDREQUEST("Hubo un error en su petición.", 400),
    NOTFOUND("Recurso no encontrado.", 404),
    INTERNALERROR("Error interno en el servidor.", 500),
    ERRORCONSULTA("Error al realizar la consulta.", 500),
    CONFLICT("Conflicto en la petición.", 409),
    MODULOEXIST("Ya existe un registro con estos datos.", 409),
    INGRESENOMBRE("Por favor, ingrese su nombre.", 400),
    VALIDACION("Datos inválidos.", 422), // Se cambió a un código HTTP más adecuado


    UNAUTHORIZED("No autorizado. Por favor, inicie sesión.", 401),
    FORBIDDEN("Acceso denegado. No tiene permisos suficientes.", 403),
    NOCONTENT("No hay contenido disponible.", 204),
    BADFORMAT("El formato de los datos es incorrecto.", 400),
    REQUIREDFIELD("El campo obligatorio está ausente.", 400),
    STATUSINVALID("El estado actual del recurso no permite esta acción.", 409),
    RESOURCEINUSE("El recurso está en uso y no se puede modificar.", 423),
    DATABASEERROR("Error en la base de datos.", 500),
    RESOURCETIMEOUT("El tiempo de espera para acceder al recurso ha expirado.", 504),
    EXTERNALSERVICEERROR("Fallo en la respuesta del servicio externo.", 502),
    SERVICEUNAVAILABLE("El servicio no está disponible en este momento.", 503),
    METHODNOTALLOWED("Método no permitido para este recurso.", 405),
    EMPTYRESULT("La operación fue exitosa, pero no se encontraron resultados.",204);

    private String key;
    private int code;

    private EMessage(String key, int code) {
        this.key = key;
        this.code = code;
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
