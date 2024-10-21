package ute.edu.java.corte2.service;

import java.util.List;

import ute.edu.java.corte2.model.Proveedor;

public interface ProveedorService {
    List<Proveedor> findAll();

    Proveedor createProveedor(Proveedor proveedor);

    Proveedor searchProveedorById(Integer nit);

    void deleteProveedor(Integer nit);
}
