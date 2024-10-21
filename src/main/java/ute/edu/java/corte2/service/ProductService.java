package ute.edu.java.corte2.service;

import java.util.List;

import ute.edu.java.corte2.model.Product;

public interface ProductService {
    
    List<Product> findAll();

    Product createProduct(Product product);

    Product searchProductById(Integer codigo);

    void deleteProduct(Integer codigo);

}
