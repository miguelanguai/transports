package com.example.transports.authentication;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.transports.authentication.model.Token;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    /**
     * Retrieves all tokens the driver passed as parameter has
     * 
     * @param userId
     * @return {@link Token}
     */
    @Query("""
            select t from Token t inner join DriverEntity u on t.driver.id = u.id
            where t.driver.id = :driverId and t.loggedOut = false
            """)
    List<Token> findAllTokensByDriver(Long driverId);

    /**
     * find the token that is passed by parameter
     * 
     * @param token
     * @return {@link Token}
     */
    Optional<Token> findByToken(String token);
}
