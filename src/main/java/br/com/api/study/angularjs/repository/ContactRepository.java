package br.com.api.study.angularjs.repository;

import br.com.api.study.angularjs.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
}
