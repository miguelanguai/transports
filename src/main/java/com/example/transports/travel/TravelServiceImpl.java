package com.example.transports.travel;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transports.travel.model.TravelDto;
import com.example.transports.travel.model.TravelEntity;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    TravelRepository travelRepository;

    @Override
    public List<TravelEntity> findAll() {
        return this.travelRepository.findAll();
    }

    @Override
    public TravelEntity findById(Long id) throws Exception {
        return this.travelRepository.findById(id).orElseThrow(() -> new Exception("Not exists"));
    }

    @Override
    public void save(TravelDto travelDto) throws Exception {
        TravelEntity travelEntity = new TravelEntity();
        BeanUtils.copyProperties(travelDto, travelEntity);
        this.travelRepository.save(travelEntity);
    }

    @Override
    public void update(Long id, TravelDto travelDto) throws Exception {
        TravelEntity travelEntity = this.travelRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(travelDto, travelEntity);
        travelEntity.setId(id);
        this.travelRepository.save(travelEntity);
    }

    @Override
    public void delete(Long id) {
        this.travelRepository.deleteById(id);
    }

}
