package com.example.transports.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transports.user.model.DriverEntity;

public interface DriverRepository extends JpaRepository<DriverEntity, Long> {

    /**
     * finds a {@link DriverEntity} by passing his username
     * 
     * @param username
     * @return {@link DriverEntity}
     */
    Optional<DriverEntity> findByUsername(String username);
}