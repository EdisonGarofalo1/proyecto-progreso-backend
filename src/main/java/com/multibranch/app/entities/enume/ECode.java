package com.multibranch.app.entities.enume;
public enum ECode {
    CODE_EXECUTE_DATASOURCE(101),
    CODE_EXECUTE_API(102),
    CODE_EXECUTE_MICRO(103),
    CODE_ERROR_EXECUTE_DATASOURCE(401),
    CODE_ERROR_EXECUTE_API(402),
    CODE_ERROR_EXECUTE_MICRO(403),
    CODE_ERROR_GET_ITEM(701),
    CODE_ERROR_BAD_REQUEST(702);
    private int code;

    private ECode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
