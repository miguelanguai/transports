package com.example.transports.authentication;

public class AuthenticationResponse {
    private String token;
    private String message;

    public AuthenticationResponse(String token, String message) {
        this.token = token;
        this.message = message;
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
     * @return message
     */
    public String getMessage() {
        return message;
    }
}
