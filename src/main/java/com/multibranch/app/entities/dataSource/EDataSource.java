package com.multibranch.app.entities.dataSource;

public enum EDataSource {
    ERROR_EXECUTE("Se produjo un error al momento de procesar la información, por favor reintente nuevaente."),
    ERROR_MAP_PARAMS("Se produjo un error al momento de procesar los parametros, por favor reintente nuevaente.");

    private String message;

    private EDataSource(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
