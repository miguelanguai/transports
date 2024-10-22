package com.example.transports.truck;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transports.truck.model.TruckEntity;

public interface TruckRepository extends JpaRepository<TruckEntity, Long> {

}
