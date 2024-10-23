package com.example.transports.truck.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "truck")
public class TruckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "truck_id", nullable = false)
    private Long id;

    @Column(name = "numberPlate", nullable = false)
    private String numberPlate;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "kilometers", nullable = false)
    private Integer kilometers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }
}
