package com.example.transports.destination;

import java.util.List;

import com.example.transports.destination.model.DestinationDto;
import com.example.transports.destination.model.DestinationEntity;

public interface DestinationService {

    List<DestinationEntity> findAll();

    DestinationEntity findById(Long id);

    void save(DestinationDto destinationDto) throws Exception;

    void update(Long id, DestinationDto destinationDto) throws Exception;

    void delete(Long id);
}
