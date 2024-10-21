package ute.edu.java.corte2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ute.edu.java.corte2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
