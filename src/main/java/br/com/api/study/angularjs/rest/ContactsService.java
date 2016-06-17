package br.com.api.study.angularjs.rest;

import br.com.api.study.angularjs.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContactsService {

    public List<Contact> findAll();
    public void add(Contact contact);

}
