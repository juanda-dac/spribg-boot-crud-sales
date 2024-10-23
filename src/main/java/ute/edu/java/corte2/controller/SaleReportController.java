package ute.edu.java.corte2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ute.edu.java.corte2.model.Sale;
import ute.edu.java.corte2.model.SaleReport;
import ute.edu.java.corte2.service.SaleReportService;
import ute.edu.java.corte2.service.SaleService;

import java.util.List;

@ConditionalOnExpression("${app.controllers.SaleReportController:false}")
@Controller
@RequestMapping("/reports")
public class SaleReportController {
    
    @Autowired
    SaleReportService saleReportService;

    @Autowired
    SaleService saleService;

    @GetMapping("/")
    public String findAllReports(Model model) {
        model.addAttribute("saleReports", saleReportService.findAllReports());
        return "/views/saleReport/list";
    }

    @GetMapping("/sale/{saleId}")
    public String findAllReportsBySale(Model model, @PathVariable int saleId) {
        Sale sale = saleService.findSaleById(saleId);
        List<SaleReport> sales = saleReportService.findAllReportsBySale(sale);
        model.addAttribute("saleReports", sales);
        model.addAttribute("sale", sale);
        return "/views/saleReport/listReport";
    }


}
