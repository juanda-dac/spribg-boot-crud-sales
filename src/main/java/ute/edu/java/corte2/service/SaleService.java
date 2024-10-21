package ute.edu.java.corte2.service;

import ute.edu.java.corte2.model.Sale;

import java.util.List;

public interface SaleService {
    
    List<Sale> findAll();

    Sale findSaleById(int id);

    Sale createSale(Sale sale);

    void deleteSaleById(int id);

}
