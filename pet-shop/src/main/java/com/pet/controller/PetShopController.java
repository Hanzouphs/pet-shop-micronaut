package com.pet.controller;

import com.pet.model.entity.DogEntity;
import com.pet.model.repository.DogRepository;
import com.pet.model.service.DogService;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Controller("/pet-shop")

public class PetShopController {


    DogService service = new DogService(new DogRepository() {
        @Override
        public <S extends DogEntity> @NonNull S save(@NonNull S entity) {
            return null;
        }

        @Override
        public <S extends DogEntity> @NonNull S update(@NonNull S entity) {
            return null;
        }

        @Override
        public @NonNull <S extends DogEntity> List<S> updateAll(@NonNull Iterable<S> entities) {
            return List.of();
        }

        @Override
        public @NonNull <S extends DogEntity> List<S> saveAll(@NonNull Iterable<S> entities) {
            return List.of();
        }

        @Override
        public @NonNull Optional<DogEntity> findById(@NonNull Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(@NonNull Long aLong) {
            return false;
        }

        @Override
        public @NonNull List<DogEntity> findAll() {
            return List.of();
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(@NonNull Long aLong) {

        }

        @Override
        public void delete(@NonNull DogEntity entity) {

        }

        @Override
        public void deleteAll(@NonNull Iterable<? extends DogEntity> entities) {

        }

        @Override
        public void deleteAll() {

        }
    });

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public DogEntity findById(Long id) {
        return service.findById(id);
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<DogEntity> findAll(){
        return service.findAll();
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public DogEntity create(@Body DogEntity entity)  {
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