package com.Nall99.Store.repositories;

import com.Nall99.Store.models.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierModel, Long> {
    SupplierModel findByName(String name);
}
