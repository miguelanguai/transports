package com.example.transports.truck;

import java.util.List;

import com.example.transports.truck.model.TruckDto;
import com.example.transports.truck.model.TruckEntity;

public interface TruckService {

    List<TruckEntity> findAll();

    TruckEntity findById(Long id) throws Exception;

    void save(TruckDto truckDto) throws Exception;

    void update(Long id, TruckDto truckDto) throws Exception;

    void delete(Long id);
}
