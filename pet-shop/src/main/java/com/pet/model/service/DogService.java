package com.pet.model.service;

import com.pet.exceptions.ResourceNotFoundException;
import com.pet.model.entity.DogEntity;
import com.pet.model.repository.DogRepository;
import io.micronaut.context.annotation.Prototype;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

@Prototype
public class DogService {

    private final Logger logger = Logger.getLogger(DogService.class.getName());

    @Inject
    DogRepository repository;


    public DogEntity findById(Long id) {
        logger.info("Find Dog by id: " + id);
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
    }


    public List<DogEntity> findAll() {
        logger.info("Find all Dogs");
        return repository.findAll();
    }

    public DogEntity create(DogEntity dog) {
        logger.info("Create Dog: " + dog);
        return repository.save(dog);
    }

    public DogEntity update(DogEntity dog) {
        logger.info("Update Dog: " + dog);

        var entity = repository.findById(dog.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));

        entity.setCastrated(dog.getCastrated());
        entity.setDogBreed(dog.getDogBreed());
        entity.setDogName(dog.getDogName());
        entity.setDogPort(dog.getDogPort());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Delete a Dog off id: " + id);
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        repository.delete(entity);

    }


}
