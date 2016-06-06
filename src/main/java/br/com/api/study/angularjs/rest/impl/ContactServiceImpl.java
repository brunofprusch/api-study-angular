package br.com.api.study.angularjs.rest.impl;

import br.com.api.study.angularjs.model.Carrier;
import br.com.api.study.angularjs.model.Contact;
import br.com.api.study.angularjs.rest.ContactsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/contact")
public class ContactServiceImpl implements ContactsService {

    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Contact> findAll() {
        Carrier claro = new Carrier("Claro", 36, Carrier.CarrierCategory.CELL);
        Carrier vivo = new Carrier("Vivo", 15, Carrier.CarrierCategory.CELL);
        Carrier tim = new Carrier("Tim", 41, Carrier.CarrierCategory.CELL);
        Carrier oi = new Carrier("Oi", 14, Carrier.CarrierCategory.CELL);

        Contact contactOne = new Contact("Bruno Feldmann Prusch", "51 9414-7667", new Date(), claro);
        Contact contactTwo = new Contact("Bruna Nichele Da Rosa", "51 8104-9781", new Date(), claro);
        Contact contactThree = new Contact("Daniel S. Prusch", "51 8447-0884", new Date(), vivo);

        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(contactOne);
        contacts.add(contactTwo);
        contacts.add(contactThree);

        return contacts;
    }
}
