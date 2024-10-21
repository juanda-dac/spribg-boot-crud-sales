package ute.edu.java.corte2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ute.edu.java.corte2.model.Product;
import ute.edu.java.corte2.repository.ProductRepository;
import ute.edu.java.corte2.repository.ProveedorRepository;
import ute.edu.java.corte2.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product searchProductById(Integer codigo) {
        return productRepository.findById(codigo).orElse(null);
    }

    @Override
    public void deleteProduct(Integer codigo) {
        productRepository.deleteById(codigo);
    }
    
}
