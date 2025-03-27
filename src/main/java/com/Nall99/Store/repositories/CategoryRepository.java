package com.Nall99.Store.repositories;

import com.Nall99.Store.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
    CategoryModel findByName(String name);
}
