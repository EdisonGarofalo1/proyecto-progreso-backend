package com.multibranch.app.entities.dataSource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StoredProcedureEntity  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer quantityParams = 0;
    private List<Object> listParams = new ArrayList();
    private Map<String, Object> input = new LinkedHashMap();
//    private Map<String, Object> output = new LinkedHashMap<>();


    public StoredProcedureEntity(String name) {
        this.name = name;
    }

    public void addInput(String key, Object value) {
        this.input.put(key, value);
    }
//    public void addOutput(String key, Object value) {
//        this.output.put(key, value);
//    }


    public StoredProcedureEntity(String name, Integer quantityParams, List<Object> listParams, Map<String, Object> input) {
        this.name = name;
        this.quantityParams = quantityParams;
        this.listParams = listParams;
        this.input = input;
//        this.output = output;
    }

    public StoredProcedureEntity() {
    }






    public String getName() {
        return this.name;
    }

    public Integer getQuantityParams() {
        return this.quantityParams;
    }

    public List<Object> getListParams() {
        return this.listParams;
    }

    public Map<String, Object> getInput() {
        return this.input;
    }
//    public Map<String, Object> getOutput() {return this.output;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantityParams(Integer quantityParams) {
        this.quantityParams = quantityParams;
    }

    public void setListParams(List<Object> listParams) {
        this.listParams = listParams;
    }

    public void setInput(Map<String, Object> input) {
        this.input = input;
    }
//    public void setOutput(Map<String, Object> output) {this.output = output;
//    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof StoredProcedureEntity)) {
            return false;
        } else {
            StoredProcedureEntity other = (StoredProcedureEntity)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$quantityParams = this.getQuantityParams();
                    Object other$quantityParams = other.getQuantityParams();
                    if (this$quantityParams == null) {
                        if (other$quantityParams == null) {
                            break label59;
                        }
                    } else if (this$quantityParams.equals(other$quantityParams)) {
                        break label59;
                    }

                    return false;
                }

                Object this$name = this.getName();
                Object other$name = other.getName();
                if (this$name == null) {
                    if (other$name != null) {
                        return false;
                    }
                } else if (!this$name.equals(other$name)) {
                    return false;
                }

                Object this$listParams = this.getListParams();
                Object other$listParams = other.getListParams();
                if (this$listParams == null) {
                    if (other$listParams != null) {
                        return false;
                    }
                } else if (!this$listParams.equals(other$listParams)) {
                    return false;
                }

                Object this$input = this.getInput();
                Object other$input = other.getInput();
                if (this$input == null) {
                    if (other$input != null) {
                        return false;
                    }
                } else if (!this$input.equals(other$input)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof StoredProcedureEntity;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $quantityParams = this.getQuantityParams();
        result = result * 59 + ($quantityParams == null ? 43 : $quantityParams.hashCode());
        Object $name = this.getName();
        result = result * 59 + ($name == null ? 43 : $name.hashCode());
        Object $listParams = this.getListParams();
        result = result * 59 + ($listParams == null ? 43 : $listParams.hashCode());
        Object $input = this.getInput();
        result = result * 59 + ($input == null ? 43 : $input.hashCode());
        return result;
    }

    public String toString() {
        String var10000 = this.getName();
        return "StoredProcedureEntity(name=" + var10000 + ", quantityParams=" + this.getQuantityParams() + ", listParams=" + this.getListParams() + ", input=" + this.getInput() + ")";
    }
}