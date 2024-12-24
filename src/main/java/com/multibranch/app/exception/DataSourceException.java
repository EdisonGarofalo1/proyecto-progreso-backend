package com.multibranch.app.exception;

public class DataSourceException extends Exception {

    private int code;
    private String personalizedMessage;

    public DataSourceException(Throwable e, int code, String personalizedMessage) {
        super(e);
        this.code = code;
        this.personalizedMessage = personalizedMessage;
    }

    public DataSourceException(int code, String personalizedMessage) {
        this.code = code;
        this.personalizedMessage = personalizedMessage;
    }

    public DataSourceException() {
    }

    public int getCode() {
        return this.code;
    }

    public String getPersonalizedMessage() {
        return this.personalizedMessage;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPersonalizedMessage(String personalizedMessage) {
        this.personalizedMessage = personalizedMessage;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof DataSourceException)) {
            return false;
        } else {
            DataSourceException other = (DataSourceException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$personalizedMessage = this.getPersonalizedMessage();
                Object other$personalizedMessage = other.getPersonalizedMessage();
                if (this$personalizedMessage == null) {
                    if (other$personalizedMessage != null) {
                        return false;
                    }
                } else if (!this$personalizedMessage.equals(other$personalizedMessage)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof DataSourceException;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getCode();
        Object $personalizedMessage = this.getPersonalizedMessage();
        result = result * 59 + ($personalizedMessage == null ? 43 : $personalizedMessage.hashCode());
        return result;
    }

    public String toString() {
        int var10000 = this.getCode();
        return "DataSourceException(code=" + var10000 + ", personalizedMessage=" + this.getPersonalizedMessage() + ")";
    }
}
