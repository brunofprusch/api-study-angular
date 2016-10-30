package br.com.api.study.angularjs.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="contact")
public class Contact {
    @Id
    private String id;
    private String name;
    private String phone;
    private Date date;
    private Carrier carrier;

    public Contact(){}

    public Contact(String id, String name, String phone, Date date, Carrier carrier) {
        this.setId(id);
        this.setName(name);
        this.setPhone(phone);
        this.setDate(date);
        this.setCarrier(carrier);
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
        if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
        if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
        if (date != null ? !date.equals(contact.date) : contact.date != null) return false;
        return carrier != null ? carrier.equals(contact.carrier) : contact.carrier == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (carrier != null ? carrier.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", date=" + date +
                ", carrier=" + carrier +
                '}';
    }
}
