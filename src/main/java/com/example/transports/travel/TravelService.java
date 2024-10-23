package com.example.transports.travel;

import java.util.List;

import com.example.transports.travel.model.TravelDto;
import com.example.transports.travel.model.TravelEntity;

public interface TravelService {

    List<TravelEntity> findAll();

    TravelEntity findById(Long id) throws Exception;

    void save(TravelDto travelDto) throws Exception;

    void update(Long id, TravelDto travelDto) throws Exception;

    void delete(Long id);
}
