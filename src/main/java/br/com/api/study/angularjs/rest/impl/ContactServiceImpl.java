package br.com.api.study.angularjs.rest.impl;

import br.com.api.study.angularjs.model.Contact;
import br.com.api.study.angularjs.repository.ContactRepository;
import br.com.api.study.angularjs.rest.ContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/contact")
public class ContactServiceImpl implements ContactsService {

    private static final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    private ContactRepository contactRepository;


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Contact> findAll() {
        log.info("Find all contacts.");
        return contactRepository.findAll();
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
    public Contact findContact(@PathVariable String id) {
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
