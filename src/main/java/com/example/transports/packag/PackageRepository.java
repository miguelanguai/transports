package com.example.transports.packag;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.transports.packag.model.PackageEntity;

public interface PackageRepository extends JpaRepository<PackageEntity, Long> {

    List<PackageEntity> findAllByDriverId(Long id);

    @Query("SELECT p FROM PackageEntity p WHERE p.id = :packageId AND p.driver.id = :driverId")
    Optional<PackageEntity> findByIdByDriverId(@Param("packageId") Long packageId, @Param("driverId") Long driverId);

}
