package com.example.transports.packag.model;

import com.example.transports.city.model.CityEntity;
import com.example.transports.driver.model.DriverEntity;

public class PackageDto {

    private Long code;

    private String description;

    private String destinationDirection;

    private DriverEntity driver;

    private CityEntity city;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDestinationDirection() {
        return destinationDirection;
    }

    public void setDestinationDirection(String destinationDirection) {
        this.destinationDirection = destinationDirection;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }
}
