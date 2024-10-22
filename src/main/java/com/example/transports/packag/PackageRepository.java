package com.example.transports.packag;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.transports.packag.model.PackageEntity;

public interface PackageRepository extends JpaRepository<PackageEntity, Long> {

}
