package com.example.recipe.repositories;

import com.example.recipe.Domain.unitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface unitOfMeasureRepository extends CrudRepository<unitOfMeasure,Long> {

    Optional<unitOfMeasure> findByDescription(String description);
}
