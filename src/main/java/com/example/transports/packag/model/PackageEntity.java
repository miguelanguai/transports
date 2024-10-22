package com.example.transports.packag.model;

import com.example.transports.user.model.DriverEntity;
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
