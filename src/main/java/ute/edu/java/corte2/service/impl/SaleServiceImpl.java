package ute.edu.java.corte2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ute.edu.java.corte2.model.Sale;
import ute.edu.java.corte2.repository.SaleRepository;
import ute.edu.java.corte2.service.SaleService;


@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
        
    }

    @Override
    public Sale findSaleById(int id) {
        return saleRepository.findById(id).orElse(null);
    }

    @Override
    public Sale createSale(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public void deleteSaleById(int id) {
        saleRepository.deleteById(id);
    }
    
    

}
