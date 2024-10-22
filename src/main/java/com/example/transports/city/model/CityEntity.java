package com.example.transports.city.model;

import java.util.List;

import com.example.transports.destination.model.DestinationEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference("city-destinations")
    @OneToMany(mappedBy = "city")
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
