package com.example.transports.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.example.transports.authentication.TokenRepository;
import com.example.transports.authentication.model.Token;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class CustomLogoutHandler implements LogoutHandler {

    private final TokenRepository tokenRepository;

    public CustomLogoutHandler(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    /**
     * Handles the logout process by retrieving the token from the Authorization
     * header, checking if the token exists in the database, and marking it as
     * logged out.
     * 
     * @param request        The {@link HttpServletRequest} object, containing the
     *                       logout request data.
     * @param response       The {@link HttpServletResponse} object, containing the
     *                       response data.
     * @param authentication The {@link Authentication} object that may contain the
     *                       user's authentication details.
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }

        String token = authHeader.substring(7);
        Token storedToken = tokenRepository.findByToken(token).orElse(null);

        if (storedToken != null) {
            storedToken.setLoggedOut(true);
            tokenRepository.save(storedToken);
        }
    }
}
