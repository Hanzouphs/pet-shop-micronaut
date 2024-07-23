package com.pet.config;

import com.pet.model.repository.DogRepository;
import com.pet.model.service.DogService;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Singleton;

@Factory
@Singleton
public class DogConfig {

    @Bean
    public DogService DogService(DogRepository dogRepository){
        return new DogService(dogRepository);
    }

}