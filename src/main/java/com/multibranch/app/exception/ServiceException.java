package com.multibranch.app.exception;

public class ServiceException extends Exception {
    private int code;
    private String method;
    private String module;
    private String fileName;
    private String className;
    private int line;
    private String messageSystem;

    public ServiceException(Throwable e, int code, String messageSystem) {
        super(e);
        this.code = code;
        this.messageSystem = messageSystem;
        this.getStackException(e);
    }

    public ServiceException(int code, String messageSystem) {
        super(messageSystem);
        this.code = code;
        this.messageSystem = messageSystem;
    }

    private void getStackException(Throwable e) {
        StackTraceElement[] traceElements = e.getStackTrace();
        if (traceElements.length != 0) {
            this.method = traceElements[0].getMethodName();
            this.className = traceElements[0].getClassName();
            this.line = traceElements[0].getLineNumber();
            this.module = traceElements[0].getModuleName();
            this.fileName = traceElements[0].getFileName();
        }

    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ServiceException)) {
            return false;
        } else {
            ServiceException other = (ServiceException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (!super.equals(o)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else if (this.getLine() != other.getLine()) {
                return false;
            } else {
                Object this$method = this.getMethod();
                Object other$method = other.getMethod();
                if (this$method == null) {
                    if (other$method != null) {
                        return false;
                    }
                } else if (!this$method.equals(other$method)) {
                    return false;
                }

                label71: {
                    Object this$module = this.getModule();
                    Object other$module = other.getModule();
                    if (this$module == null) {
                        if (other$module == null) {
                            break label71;
                        }
                    } else if (this$module.equals(other$module)) {
                        break label71;
                    }

                    return false;
                }

                label64: {
                    Object this$fileName = this.getFileName();
                    Object other$fileName = other.getFileName();
                    if (this$fileName == null) {
                        if (other$fileName == null) {
                            break label64;
                        }
                    } else if (this$fileName.equals(other$fileName)) {
                        break label64;
                    }

                    return false;
                }

                Object this$className = this.getClassName();
                Object other$className = other.getClassName();
                if (this$className == null) {
                    if (other$className != null) {
                        return false;
                    }
                } else if (!this$className.equals(other$className)) {
                    return false;
                }

                Object this$messageSystem = this.getMessageSystem();
                Object other$messageSystem = other.getMessageSystem();
                if (this$messageSystem == null) {
                    if (other$messageSystem != null) {
                        return false;
                    }
                } else if (!this$messageSystem.equals(other$messageSystem)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ServiceException;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = super.hashCode();
        result = result * 59 + this.getCode();
        result = result * 59 + this.getLine();
        Object $method = this.getMethod();
        result = result * 59 + ($method == null ? 43 : $method.hashCode());
        Object $module = this.getModule();
        result = result * 59 + ($module == null ? 43 : $module.hashCode());
        Object $fileName = this.getFileName();
        result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
        Object $className = this.getClassName();
        result = result * 59 + ($className == null ? 43 : $className.hashCode());
        Object $messageSystem = this.getMessageSystem();
        result = result * 59 + ($messageSystem == null ? 43 : $messageSystem.hashCode());
        return result;
    }

    public ServiceException(int code, String method, String module, String fileName, String className, int line, String messageSystem) {
        this.code = code;
        this.method = method;
        this.module = module;
        this.fileName = fileName;
        this.className = className;
        this.line = line;
        this.messageSystem = messageSystem;
    }

    public ServiceException() {
    }

    public int getCode() {
        return this.code;
    }

    public String getMethod() {
        return this.method;
    }

    public String getModule() {
        return this.module;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getClassName() {
        return this.className;
    }

    public int getLine() {
        return this.line;
    }

    public String getMessageSystem() {
        return this.messageSystem;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public void setMessageSystem(String messageSystem) {
        this.messageSystem = messageSystem;
    }

    public String toString() {
        int var10000 = this.getCode();
        return "ServiceException(code=" + var10000 + ", method=" + this.getMethod() + ", module=" + this.getModule() + ", fileName=" + this.getFileName() + ", className=" + this.getClassName() + ", line=" + this.getLine() + ", messageSystem=" + this.getMessageSystem() + ")";
    }

}
