package com.example.recipe.repositories;

import com.example.recipe.Domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface categoryRepository extends CrudRepository<Category,Long> {
    Optional<Category> findByDescription(String description);
}
