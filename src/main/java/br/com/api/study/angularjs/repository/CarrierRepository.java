package br.com.api.study.angularjs.repository;

import br.com.api.study.angularjs.model.Carrier;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarrierRepository extends MongoRepository<Carrier, String> {
}
