package ute.edu.java.corte2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ute.edu.java.corte2.model.Sale;
import ute.edu.java.corte2.model.SaleReport;

public interface SaleReportRepository extends JpaRepository<SaleReport, Integer> {
    List<SaleReport> findSaleReportByVenta(Sale venta);
}
