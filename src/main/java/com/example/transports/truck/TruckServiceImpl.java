package com.example.transports.truck;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transports.truck.model.TruckDto;
import com.example.transports.truck.model.TruckEntity;

@Service
public class TruckServiceImpl implements TruckService {

    @Autowired
    TruckRepository truckRepository;

    @Override
    public List<TruckEntity> findAll() {
        return this.truckRepository.findAll();
    }

    @Override
    public TruckEntity findById(Long id) throws Exception {
        return this.truckRepository.findById(id).orElseThrow(() -> new Exception("Not exists"));
    }

    @Override
    public void save(TruckDto truckDto) throws Exception {
        TruckEntity truckEntity = new TruckEntity();
        BeanUtils.copyProperties(truckDto, truckEntity);
        this.truckRepository.save(truckEntity);
    }

    @Override
    public void update(Long id, TruckDto truckDto) throws Exception {
        TruckEntity truckEntity = this.truckRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(truckDto, truckEntity);
        truckEntity.setId(id);
        this.truckRepository.save(truckEntity);

    }

    @Override
    public void delete(Long id) {
        this.truckRepository.deleteById(id);
    }

}
