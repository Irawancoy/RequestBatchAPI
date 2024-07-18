package com.example.batchAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.batchAPI.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

}
