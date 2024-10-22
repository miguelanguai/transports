package com.example.transports.destination;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transports.destination.model.DestinationDto;
import com.example.transports.destination.model.DestinationEntity;

@Service
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    DestinationRepository destinationRepository;

    @Override
    public List<DestinationEntity> findAll() {
        return this.destinationRepository.findAll();
    }

    @Override
    public DestinationEntity findById(Long id) {
        return this.destinationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(DestinationDto destinationDto) throws Exception {
        DestinationEntity destinationEntity = new DestinationEntity();
        BeanUtils.copyProperties(destinationDto, destinationEntity);
        this.destinationRepository.save(destinationEntity);
    }

    @Override
    public void update(Long id, DestinationDto destinationDto) throws Exception {
        DestinationEntity destinationEntity = this.destinationRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(destinationDto, destinationEntity);
        destinationEntity.setId(id);
        this.destinationRepository.save(destinationEntity);
    }

    @Override
    public void delete(Long id) {
        this.destinationRepository.deleteById(id);
    }

}
