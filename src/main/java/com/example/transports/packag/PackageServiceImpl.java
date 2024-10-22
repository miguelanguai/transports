package com.example.transports.packag;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transports.packag.model.PackageDto;
import com.example.transports.packag.model.PackageEntity;

@Service
public class PackageServiceImpl implements PackageService {

    @Autowired
    PackageRepository packageRepository;

    @Override
    public List<PackageEntity> findAll() {
        return this.packageRepository.findAll();
    }

    @Override
    public PackageEntity findById(Long id) {
        return this.packageRepository.findById(id).orElse(null);
    }

    @Override
    public void save(PackageDto packageDto) throws Exception {
        PackageEntity packageEntity = new PackageEntity();
        BeanUtils.copyProperties(packageDto, packageEntity);
        this.packageRepository.save(packageEntity);
    }

    @Override
    public void update(Long code, PackageDto packageDto) throws Exception {
        PackageEntity packageEntity = this.packageRepository.findById(code).orElse(null);
        BeanUtils.copyProperties(packageDto, packageEntity);
        packageEntity.setCode(code);
        this.packageRepository.save(packageEntity);
    }

    @Override
    public void delete(Long code) {
        this.packageRepository.deleteById(code);
    }

}
