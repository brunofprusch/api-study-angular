package br.com.api.study.angularjs.rest.impl;

import br.com.api.study.angularjs.model.Carrier;
import br.com.api.study.angularjs.rest.CarrierService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/carrier")
public class CarrierServiceImpl implements CarrierService {


    @RequestMapping(value = "/all",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Carrier> findAll() {
        Carrier claro = new Carrier("Claro", 36, Carrier.CarrierCategory.CELL);
        Carrier vivo = new Carrier("Vivo", 15, Carrier.CarrierCategory.CELL);
        Carrier tim = new Carrier("Tim", 41, Carrier.CarrierCategory.CELL);
        Carrier oi = new Carrier("Oi", 14, Carrier.CarrierCategory.CELL);
        Carrier net = new Carrier("NET", 00, Carrier.CarrierCategory.FIXED);
        Carrier gvt = new Carrier("GVT", 21, Carrier.CarrierCategory.FIXED);

        List<Carrier> carriers = new ArrayList<Carrier>();
        carriers.add(claro);
        carriers.add(vivo);
        carriers.add(tim);
        carriers.add(oi);
        carriers.add(net);
        carriers.add(gvt);
        return carriers;
    }
}
