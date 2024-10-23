package com.example.transports.travel;

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

import com.example.transports.travel.model.TravelDto;
import com.example.transports.travel.model.TravelEntity;

@RequestMapping(value = "")
@RestController
@CrossOrigin(origins = "*")
public class TravelController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    TravelService travelService;

    @RequestMapping(path = "/a/travel", method = RequestMethod.GET)
    public List<TravelDto> findAll() {
        List<TravelEntity> travels = this.travelService.findAll();
        return travels.stream().map(e -> mapper.map(e, TravelDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/a/travel/{id}", method = RequestMethod.GET)
    public TravelDto findById(@PathVariable(name = "id", required = true) Long id) {
        TravelDto travelDto = new TravelDto();
        TravelEntity travelEntity = travelService.findById(id);
        BeanUtils.copyProperties(travelEntity, travelDto);
        return travelDto;
    }

    @RequestMapping(path = { "/a/travel" }, method = RequestMethod.PUT)
    public void save(@RequestBody TravelDto travelDto) throws Exception {
        this.travelService.save(travelDto);
    }

    @RequestMapping(path = { "/a/travel/{id}" }, method = RequestMethod.PUT)
    public void update(@PathVariable(name = "id") Long code, @RequestBody TravelDto travelDto) throws Exception {
        this.travelService.update(code, travelDto);
    }

    @RequestMapping(path = "a/travel/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.travelService.delete(id);
    }
}
