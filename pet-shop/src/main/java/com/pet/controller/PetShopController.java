package com.pet.controller;

import com.pet.model.entity.DogEntity;
import com.pet.model.service.DogService;
import io.micronaut.context.annotation.Prototype;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/pet-shop")
public class PetShopController {

    @Prototype
    @Inject
    private DogService service;

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public DogEntity findById(Long id) {
        return service.findById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<DogEntity> findAll(){
        return service.findAll();
    }

    @Post(produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public DogEntity create(@Body DogEntity entity) {
        return service.create(entity);
    }

    @Put(produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON)
    public DogEntity update(@Body DogEntity entity) {
        return service.update(entity);
    }

    @Delete(value = "/{id}")
    public HttpResponse<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return HttpResponse.noContent();
    }
}