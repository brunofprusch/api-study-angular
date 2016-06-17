package br.com.api.study.angularjs.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Carrier {

    public enum CarrierCategory {
        CELL,
        FIXED
    }

    private String name;
    private Integer code;
    private CarrierCategory category;

    public Carrier(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Carrier carrier = (Carrier) o;

        if (name != null ? !name.equals(carrier.name) : carrier.name != null) return false;
        if (code != null ? !code.equals(carrier.code) : carrier.code != null) return false;
        return category == carrier.category;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", category=" + category +
                '}';
    }
}
