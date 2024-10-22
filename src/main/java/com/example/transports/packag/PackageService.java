package com.example.transports.packag;

import java.util.List;

import com.example.transports.packag.model.PackageDto;
import com.example.transports.packag.model.PackageEntity;

public interface PackageService {

    List<PackageEntity> findAll();

    PackageEntity findById(Long id);

    void save(PackageDto employeeDto) throws Exception;

    void update(Long code, PackageDto packageDto) throws Exception;

    void delete(Long code);
}
