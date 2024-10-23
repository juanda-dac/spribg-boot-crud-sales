package ute.edu.java.corte2.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ute.edu.java.corte2.model.Sale;
import ute.edu.java.corte2.model.SaleReport;
import ute.edu.java.corte2.repository.SaleReportRepository;
import ute.edu.java.corte2.repository.SaleRepository;
import ute.edu.java.corte2.service.SaleReportService;

@Service
@Transactional
public class SaleReportServiceImpl implements SaleReportService {

    @Autowired
    SaleReportRepository saleReportRepository;

    @Override
    public List<SaleReport> findAllReports() {
        return saleReportRepository.findAll();
    }

    @Override
    public List<SaleReport> findAllReportsBySale(Sale sale) {
        List<SaleReport> sales = saleReportRepository.findSaleReportByVenta(sale);
        return sales;
    }

    @Override
    public SaleReport findSaleReportById(int id) {
        return saleReportRepository.findById(id).orElse(null);
    }

    @Override
    public SaleReport createSaleReport(SaleReport saleReport) {
        return saleReportRepository.save(saleReport);
    }

    @Override
    public List<SaleReport> createManySaleReports(List<SaleReport> saleReports) {
        saleReportRepository.saveAll(saleReports);
        return saleReports;
    }

    @Override
    public void deleteSaleReport(int id) {
        saleReportRepository.deleteById(id);
    }
    
}
