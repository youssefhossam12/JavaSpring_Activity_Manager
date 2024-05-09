package com.example.activities.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig {
    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper instance = new ObjectMapper();
        instance.registerModule(new JavaTimeModule());
        instance.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        instance.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);
        instance.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        instance.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        return instance;
    }
}
