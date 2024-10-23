package ute.edu.java.corte2.service;

import java.util.List;

import ute.edu.java.corte2.model.Sale;
import ute.edu.java.corte2.model.SaleReport;

public interface SaleReportService {
    
    List<SaleReport> findAllReports();

    List<SaleReport> findAllReportsBySale(Sale sale);
    
    SaleReport findSaleReportById(int id);

    SaleReport createSaleReport(SaleReport saleReport);

    List<SaleReport> createManySaleReports(List<SaleReport> saleReports);

    void deleteSaleReport(int id);

}
