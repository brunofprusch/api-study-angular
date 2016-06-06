package br.com.api.study.angularjs.model;


public class Carrier {

    public enum CarrierCategory {
        CELL,
        FIXED
    }

    private String name;
    private Integer code;
    private CarrierCategory category;

    public Carrier(String name, Integer code, CarrierCategory category) {
        this.setName(name);
        this.setCode(code);
        this.setCategory(category);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CarrierCategory getCategory() {
        return category;
    }

    public void setCategory(CarrierCategory category) {
        this.category = category;
    }
}
