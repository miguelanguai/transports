package com.example.transports.packag.model;

import com.example.transports.user.model.DriverEntity;

public class PackageDto {

    private Long code;

    private String description;

    private String destinationDirection;

    private DriverEntity driver;

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

}
