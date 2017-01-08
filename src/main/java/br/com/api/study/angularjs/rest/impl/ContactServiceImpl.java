package br.com.api.study.angularjs.rest.impl;

import br.com.api.study.angularjs.model.Contact;
import br.com.api.study.angularjs.repository.ContactRepository;
import br.com.api.study.angularjs.rest.ContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/contact")
public class ContactServiceImpl implements ContactsService {

    private static final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/allWithHeader",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public ResponseEntity<List<Contact>> findAllWithHeader() {

        List<String> exposeHeaders = new ArrayList<String>();
        exposeHeaders.add("New-Header");
        exposeHeaders.add("Date");

        /*
        List<HttpMethod> exposeMethods = new ArrayList<HttpMethod>();
        exposeMethods.add(HttpMethod.GET);
        */

        HttpHeaders header = new HttpHeaders();
        header.set("New-Header", "HelloMan");
        header.setAccessControlAllowHeaders(exposeHeaders);
        header.setAccessControlExposeHeaders(exposeHeaders);
        //header.setAccessControlAllowMethods(exposeMethods);

        Contact contactOne = new Contact("OIUBD", "Bruno Feldmann Prusch", "9414-7667", new Date(), null);
        Contact contactTwo = new Contact("OIUBD", "Bruna Nichele Da Rosa", "8104-9781", new Date(), null);
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(contactOne);
        contacts.add(contactTwo);

        log.info("Find all contacts.");
        return new ResponseEntity<List<Contact>>(contacts, header, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public List<Contact> findAll() {
        List<Contact> contacts = contactRepository.findAll();
        log.info("All contacts. {}", contacts);
        return contacts;
    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = {"application/json"})
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Contact add(@RequestBody Contact contact) {
        contact.setDate(new Date());
        contactRepository.save(contact);
        log.info("Add contact. {}", contact);
        return contact;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Contact findContact(@RequestHeader("headerTest") String header, @PathVariable String id) {
        String vazio = "";
        return contactRepository.findOne(id);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Boolean deleteContact(@PathVariable String id) {
        Contact contact = contactRepository.findOne(id);
        contactRepository.delete(id);
        return Boolean.TRUE;
    }

    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
}
