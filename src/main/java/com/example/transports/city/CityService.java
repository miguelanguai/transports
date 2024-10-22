package com.example.transports.city;

import java.util.List;

import com.example.transports.city.model.CityDto;
import com.example.transports.city.model.CityEntity;

public interface CityService {

    List<CityEntity> findAll();

    CityEntity findById(Long id);

    void save(CityDto cityDto) throws Exception;

    void update(Long id, CityDto cityDto) throws Exception;

    void delete(Long id);

}
