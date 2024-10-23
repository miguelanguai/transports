package com.example.transports.city;

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

import com.example.transports.city.model.CityDto;
import com.example.transports.city.model.CityEntity;

@RequestMapping(value = "")
@RestController
@CrossOrigin(origins = "*")
public class CityController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    CityService cityService;

    @RequestMapping(path = "/d/city", method = RequestMethod.GET)
    public List<CityDto> findAll() {
        List<CityEntity> cities = this.cityService.findAll();
        return cities.stream().map(e -> mapper.map(e, CityDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/d/city/{id}", method = RequestMethod.GET)
    public CityDto findById(@PathVariable(name = "id", required = true) Long id) {
        CityDto cityDto = new CityDto();
        CityEntity city = cityService.findById(id);
        BeanUtils.copyProperties(city, cityDto);
        return cityDto;
    }

    @RequestMapping(path = { "/a/city" }, method = RequestMethod.PUT)
    public void save(@RequestBody CityDto cityDto) throws Exception {
        this.cityService.save(cityDto);
    }

    @RequestMapping(path = { "/a/city/{code}" }, method = RequestMethod.PUT)
    public void update(@PathVariable(name = "code", required = false) Long code, @RequestBody CityDto cityDto)
            throws Exception {
        this.cityService.update(code, cityDto);
    }

    @RequestMapping(path = "a/city/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) throws Exception {
        this.cityService.delete(id);
    }
}
