package com.example.transports.city.model;

import java.util.List;

import com.example.transports.destination.model.DestinationEntity;

public class CityDto {

    private Long id;

    private String name;

    private List<DestinationEntity> destinations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DestinationEntity> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<DestinationEntity> destinations) {
        this.destinations = destinations;
    }
}
