package com.example.transports.user;

import com.example.transports.user.model.DriverDto;
import com.example.transports.user.model.DriverEntity;

public interface DriverService {

    /**
     * returns current user email
     * 
     * @return the {@link UserEntity}'s mail
     */
    String getUserEmail();

    /**
     * returns current driver
     * 
     * @param driver
     * @return current {@link DriverEntity}
     */
    DriverEntity getCurrentUser();

    /**
     * updates a user
     * 
     * @param id
     * @param userDto
     */
    void save(Long id, DriverDto userDto);

    /**
     * checks if {@link DriverEntity} passed in the parameter is admin
     * 
     * @param {@link DriverEntity}
     * @return boolean
     */
    boolean isAdmin(DriverEntity user);
}
