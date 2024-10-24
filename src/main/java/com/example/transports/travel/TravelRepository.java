package com.example.transports.travel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.transports.travel.model.TravelEntity;

public interface TravelRepository extends JpaRepository<TravelEntity, Long> {

    List<TravelEntity> findAllByDriverId(Long id);

    @Query("SELECT t FROM TravelEntity t WHERE t.id = :travelId AND t.driver.id = :driverId")
    Optional<TravelEntity> findByIdByDriverId(@Param("travelId") Long travelId, @Param("driverId") Long driverId);

}
