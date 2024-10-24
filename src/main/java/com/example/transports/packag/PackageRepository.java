package com.example.transports.packag;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transports.packag.model.PackageEntity;

public interface PackageRepository extends JpaRepository<PackageEntity, Long> {

    List<PackageEntity> findAllByDriverId(Long id);

}
