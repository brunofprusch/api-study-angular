package br.com.api.study.angularjs.rest.impl;

import br.com.api.study.angularjs.model.Carrier;
import br.com.api.study.angularjs.repository.CarrierRepository;
import br.com.api.study.angularjs.rest.CarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carrier")
public class CarrierServiceImpl implements CarrierService {

    @Autowired CarrierRepository carrierRepository;

    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Carrier> findAll() {
        return carrierRepository.findAll();
    }

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            produces = {"application/json"})
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Carrier add(@RequestBody Carrier carrier) {
        return carrierRepository.save(carrier);
    }

    public void setCarrierRepository(CarrierRepository carrierRepository) {
        this.carrierRepository = carrierRepository;
    }
}
