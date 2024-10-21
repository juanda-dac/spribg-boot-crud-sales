package ute.edu.java.corte2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ute.edu.java.corte2.model.Proveedor;
import ute.edu.java.corte2.repository.ProveedorRepository;
import ute.edu.java.corte2.service.ProveedorService;

@Service
@Transactional
public class ProveedorServiceImpl implements ProveedorService{

    @Autowired
    ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> findAll() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor createProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor searchProveedorById(Integer nit) {
        return proveedorRepository.findById(nit).orElse(null);
    }

    @Override
    public void deleteProveedor(Integer nit) {
        proveedorRepository.deleteById(nit);
    }
    
}
