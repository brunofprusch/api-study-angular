package br.com.api.study.angularjs.rest;

import br.com.api.study.angularjs.model.Contact;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ContactsService {

    ResponseEntity<List<Contact>> findAll();
    Contact add(Contact contact);
    Contact findContact(String header, String id);
    Boolean deleteContact(String id);

}
