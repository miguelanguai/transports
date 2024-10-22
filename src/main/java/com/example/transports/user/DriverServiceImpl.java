package com.example.transports.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.transports.authentication.model.Role;
import com.example.transports.user.model.DriverDto;
import com.example.transports.user.model.DriverEntity;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getUserEmail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DriverEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        DriverEntity user = driverRepository.findByUsername(authentication.getName()).orElse(null);
        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Long id, DriverDto userDto) {
        DriverEntity user;

        if (id == null) {
            user = new DriverEntity();
        } else {
            user = this.driverRepository.findById(id).orElse(null);
        }

        BeanUtils.copyProperties(userDto, user);
        user.setId(id);
        this.driverRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAdmin(DriverEntity user) {
        return user.getRole() == Role.ADMIN;
    }
}
