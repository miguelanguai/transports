package com.example.transports.destination;

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

import com.example.transports.destination.model.DestinationDto;
import com.example.transports.destination.model.DestinationEntity;

@RequestMapping(value = "")
@RestController
@CrossOrigin(origins = "*")
public class DestinationController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    DestinationService destinationService;

    @RequestMapping(path = "/p/destination", method = RequestMethod.GET)
    public List<DestinationDto> findAll() {
        List<DestinationEntity> destinations = this.destinationService.findAll();
        return destinations.stream().map(e -> mapper.map(e, DestinationDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/p/destination/{id}", method = RequestMethod.GET)
    public DestinationDto findById(@PathVariable(name = "id", required = true) Long id) {
        DestinationDto destinationDto = new DestinationDto();
        DestinationEntity destinationEntity = destinationService.findById(id);
        BeanUtils.copyProperties(destinationEntity, destinationDto);
        return destinationDto;
    }

    @RequestMapping(path = { "/d/destination" }, method = RequestMethod.PUT)
    public void save(@RequestBody DestinationDto destinationDto) throws Exception {
        this.destinationService.save(destinationDto);
    }

    @RequestMapping(path = { "/d/destination/{code}" }, method = RequestMethod.PUT)
    public void update(@PathVariable(name = "code", required = false) Long code,
            @RequestBody DestinationDto destinationDto) throws Exception {
        this.destinationService.update(code, destinationDto);
    }

    @RequestMapping(path = "d/destination/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.destinationService.delete(id);
    }
}
