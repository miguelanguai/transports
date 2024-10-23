package com.example.transports.travel;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transports.travel.model.TravelEntity;

public interface TravelRepository extends JpaRepository<TravelEntity, Long> {

}
