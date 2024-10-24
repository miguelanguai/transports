package com.example.transports.packag;

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

import com.example.transports.packag.model.PackageDto;
import com.example.transports.packag.model.PackageEntity;

@RequestMapping(value = "")
@RestController
@CrossOrigin(origins = "*")
public class PackageController {

    @Autowired
    ModelMapper mapper;

    @Autowired
    PackageService packageService;

    @RequestMapping(path = "/a/package", method = RequestMethod.GET)
    public List<PackageDto> findAll() {
        List<PackageEntity> entities = this.packageService.findAll();
        return entities.stream().map(e -> mapper.map(e, PackageDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/d/package", method = RequestMethod.GET)
    public List<PackageDto> findAllByDriverId() {
        List<PackageEntity> entities = this.packageService.findAllByDriverId();
        return entities.stream().map(e -> mapper.map(e, PackageDto.class)).collect(Collectors.toList());
    }

    @RequestMapping(path = "/a/package/{id}", method = RequestMethod.GET)
    public PackageDto findById(@PathVariable(name = "id", required = true) Long id) throws Exception {
        PackageDto packageDto = new PackageDto();
        PackageEntity packageEntity = this.packageService.findById(id);
        BeanUtils.copyProperties(packageEntity, packageDto);
        return packageDto;
    }

    @RequestMapping(path = "/d/package/{id}", method = RequestMethod.GET)
    public PackageDto findByIdByDriverId(@PathVariable(name = "id", required = true) Long id) throws Exception {
        PackageDto packageDto = new PackageDto();
        PackageEntity packageEntity = this.packageService.findByIdByDriverId(id);
        BeanUtils.copyProperties(packageEntity, packageDto);
        return packageDto;
    }

    @RequestMapping(path = "/a/package", method = RequestMethod.PUT)
    public void save(@RequestBody PackageDto packageDto) throws Exception {
        this.packageService.save(packageDto);
    }

    @RequestMapping(path = "/a/package/{code}", method = RequestMethod.PUT)
    public void update(@PathVariable(name = "code", required = true) Long code, @RequestBody PackageDto driverDto)
            throws Exception {
        this.packageService.update(code, driverDto);
    }

    @RequestMapping(path = "/a/package/{code}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(name = "code", required = true) Long code) throws Exception {
        this.packageService.delete(code);
    }

}
