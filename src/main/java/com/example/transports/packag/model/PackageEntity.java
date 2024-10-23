package com.example.transports.packag.model;

import com.example.transports.city.model.CityEntity;
import com.example.transports.driver.model.DriverEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "package")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code", nullable = false)
    private Long code;

    @Column(name = "description")
    private String description;

    @Column(name = "destinationDirection")
    private String destinationDirection;

    @JsonBackReference("driver-packages")
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;

    @JsonBackReference("city-packages")
    @ManyToOne
    @JoinColumn(name = "city_id")
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

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

}
