package com.example.transports.truck;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.transports.truck.model.TruckDto;
import com.example.transports.truck.model.TruckEntity;

@RequestMapping(value = "")
@RestController
@CrossOrigin(origins = "*")
public class TruckController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    TruckService truckService;

    @RequestMapping(path = "/d/truck", method = RequestMethod.GET)
    public List<TruckDto> findAll() {
        List<TruckEntity> trucks = this.truckService.findAll();
        return trucks.stream().map(e -> mapper.map(e, TruckDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/d/truck/{id}", method = RequestMethod.GET)
    public TruckDto findById(@PathVariable(name = "id", required = true) Long id) throws Exception {
        TruckDto truckDto = new TruckDto();
        TruckEntity truckEntity = truckService.findById(id);
        BeanUtils.copyProperties(truckEntity, truckDto);
        return truckDto;
    }

    @RequestMapping(path = { "/a/truck" }, method = RequestMethod.PUT)
    public void save(@RequestBody TruckDto truckDto) throws Exception {
        this.truckService.save(truckDto);
    }

    @RequestMapping(path = { "/a/truck/{id}" }, method = RequestMethod.PUT)
    public void update(@PathVariable(name = "id") Long code, @RequestBody TruckDto truckDto) throws Exception {
        this.truckService.update(code, truckDto);
    }

    @RequestMapping(path = "a/truck/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.truckService.delete(id);
    }
}
