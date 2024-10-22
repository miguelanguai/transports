package com.example.transports.destination;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transports.destination.model.DestinationEntity;

public interface DestinationRepository extends JpaRepository<DestinationEntity, Long> {

}
