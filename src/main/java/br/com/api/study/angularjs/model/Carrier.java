package br.com.api.study.angularjs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="carrier")
public class Carrier {

    public enum CarrierCategory {
        CELL,
        FIXED
    }

    @Id
    private String id;
    private String name;
    private Integer code;
    private CarrierCategory category;

    public Carrier(){}

    public Carrier(String id, String name, Integer code, CarrierCategory category) {
        this.setId(id);
        this.setName(name);
        this.setCode(code);
        this.setCategory(category);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

        if (id != null ? !id.equals(carrier.id) : carrier.id != null) return false;
        if (name != null ? !name.equals(carrier.name) : carrier.name != null) return false;
        if (code != null ? !code.equals(carrier.code) : carrier.code != null) return false;
        return category == carrier.category;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Carrier{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", category=" + category +
                '}';
    }
}
