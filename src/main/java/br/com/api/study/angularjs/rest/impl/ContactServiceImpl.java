package br.com.api.study.angularjs.rest.impl;

import br.com.api.study.angularjs.model.Carrier;
import br.com.api.study.angularjs.model.Contact;
import br.com.api.study.angularjs.rest.ContactsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/contact")
public class ContactServiceImpl implements ContactsService {

    private static final Logger log = LoggerFactory.getLogger(ContactServiceImpl.class);

    public static List<Contact> contacts = initializeContacts();

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Contact> findAll() {
        log.info("Find all contacts.");
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
        contacts.add(contact);
        log.info("Add contact. {}", contact);
        return contact;
    }

    public static List<Contact> initializeContacts() {
        contacts = new ArrayList<Contact>();

        Carrier claro = new Carrier("Claro", 36, Carrier.CarrierCategory.CELL);
        Carrier vivo = new Carrier("Vivo", 15, Carrier.CarrierCategory.CELL);
        Carrier tim = new Carrier("Tim", 41, Carrier.CarrierCategory.CELL);
        Carrier oi = new Carrier("Oi", 14, Carrier.CarrierCategory.CELL);

        Contact contactOne = new Contact("JFG7D", "Bruno Feldmann Prusch", "51 9414-7667", new Date(), claro);
        Contact contactTwo = new Contact("LP76F", "Bruna Nichele Da Rosa", "51 8104-9781", new Date(), claro);
        Contact contactThree = new Contact("FDR09", "Daniel S. Prusch", "51 8447-0884", new Date(), vivo);

        contacts.add(contactOne);
        contacts.add(contactTwo);
        contacts.add(contactThree);

        return contacts;
    }
}
