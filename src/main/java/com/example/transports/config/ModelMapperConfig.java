package com.example.transports.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    /**
     * Defines a {@link Bean} for the {@link ModelMapper} instance.
     * 
     * This method is used by the Spring container to create and manage a singleton
     * instance of {@link ModelMapper} that can be injected wherever required.
     * 
     * @return A new instance of {@link ModelMapper}.
     */
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
