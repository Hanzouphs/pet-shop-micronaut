package com.pet.model.repository;
import com.pet.model.entity.DogEntity;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
@Repository
public interface DogRepository extends CrudRepository<DogEntity, Long> {
}
