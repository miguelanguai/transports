package com.example.transports.city;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transports.city.model.CityDto;
import com.example.transports.city.model.CityEntity;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public List<CityEntity> findAll() {
        return this.cityRepository.findAll();
    }

    @Override
    public CityEntity findById(Long id) {
        return this.cityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(CityDto cityDto) throws Exception {
        CityEntity cityEntity = new CityEntity();
        BeanUtils.copyProperties(cityDto, cityEntity);
        this.cityRepository.save(cityEntity);
    }

    @Override
    public void update(Long id, CityDto cityDto) throws Exception {
        CityEntity cityEntity = this.cityRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(cityDto, cityEntity);
        cityEntity.setId(id);
        this.cityRepository.save(cityEntity);
    }

    @Override
    public void delete(Long id) {
        this.cityRepository.deleteById(id);

    }

}
