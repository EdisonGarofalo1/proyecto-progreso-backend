package com.multibranch.app.entities.dataSource;
import java.io.Serializable;
public class ParamEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Object value;

    public ParamEntity(Object value) {
        this.value = value;
    }

    public ParamEntity() {
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ParamEntity)) {
            return false;
        } else {
            ParamEntity other = (ParamEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$value = this.getValue();
                Object other$value = other.getValue();
                if (this$value == null) {
                    if (other$value != null) {
                        return false;
                    }
                } else if (!this$value.equals(other$value)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ParamEntity;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $value = this.getValue();
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    public String toString() {
        return "ParamEntity(value=" + this.getValue() + ")";
    }
}