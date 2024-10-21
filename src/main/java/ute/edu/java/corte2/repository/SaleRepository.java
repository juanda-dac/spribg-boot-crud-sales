package ute.edu.java.corte2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ute.edu.java.corte2.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Integer>{
    
}
