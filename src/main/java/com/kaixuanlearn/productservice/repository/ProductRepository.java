package com.kaixuanlearn.productservice.repository;

import com.kaixuanlearn.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
