package com.example.transports.city;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transports.city.model.CityEntity;

public interface CityRepository extends JpaRepository<CityEntity, Long> {

}
