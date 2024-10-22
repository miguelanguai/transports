package com.example.transports.authentication.model;

import com.example.transports.user.model.DriverEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "token")
public class Token {

    /**
     * Unique identifier of the token. It is the primary key in the database,
     * automatically generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * The value of the authentication token assigned to the user.
     */
    @Column(name = "token")
    private String token;

    /**
     * Indicates whether the user has logged out. true if the user is logged out,
     * false otherwise.
     */
    @Column(name = "is_logged_out")
    private boolean loggedOut;

    /**
     * The user associated with this token. The relationship is many-to-one, where a
     * user can have multiple tokens.
     */
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "driver_id")
    private DriverEntity driver;

    /**
     * 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id new value of {@link #getId}.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * 
     * @param token new value of {@link #getToken}.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 
     * @return isLoggedOut
     */
    public boolean getIsLoggedOut() {
        return loggedOut;
    }

    /**
     * 
     * @param isLoggedOut new value of {@link #getIsLoggedOut}.
     */
    public void setLoggedOut(boolean loggedOut) {
        this.loggedOut = loggedOut;
    }

    /**
     * 
     * @return {@link UserEntity}
     */
    public DriverEntity getDriver() {
        return driver;
    }

    /**
     * 
     * @param {@link UserEntity} new value of {@link #getUser}.
     */
    public void setDriver(DriverEntity driver) {
        this.driver = driver;
    }
}
