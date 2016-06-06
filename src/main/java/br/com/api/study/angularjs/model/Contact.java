package br.com.api.study.angularjs.model;

import java.util.Date;

public class Contact {

    private String name;
    private String phone;
    private Date date;
    private Carrier carrier;

    public Contact(String name, String phone, Date date, Carrier carrier) {
        this.setName(name);
        this.setPhone(phone);
        this.setDate(date);
        this.setCarrier(carrier);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Carrier getCarrier() {
        return carrier;
    }

    public void setCarrier(Carrier carrier) {
        this.carrier = carrier;
    }
}
