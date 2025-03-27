package com.Nall99.Store.repositories;

import com.Nall99.Store.models.CategoryModel;
import com.Nall99.Store.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByCategory(CategoryModel category);
}
