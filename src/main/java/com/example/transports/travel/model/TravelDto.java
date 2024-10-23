package com.example.transports.travel.model;

import java.time.LocalDate;

import com.example.transports.driver.model.DriverEntity;
import com.example.transports.truck.model.TruckEntity;

public class TravelDto {

    private Long id;

    private LocalDate date;

    private DriverEntity driver;

    private TruckEntity truck;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public DriverEntity getDriver() {
        return driver;
    }

    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }

    public TruckEntity getTruck() {
        return truck;
    }

    public void setTruck(TruckEntity truck) {
        this.truck = truck;
    }
}
