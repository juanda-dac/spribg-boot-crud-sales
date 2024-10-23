package ute.edu.java.corte2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ute.edu.java.corte2.model.Sale;
import ute.edu.java.corte2.model.SaleReport;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import ute.edu.java.corte2.service.ClientService;
import ute.edu.java.corte2.service.ProductService;
import ute.edu.java.corte2.service.SaleReportService;
import ute.edu.java.corte2.service.SaleService;
import ute.edu.java.corte2.service.UserService;
import java.lang.Math;

@Controller
@RequestMapping("/sales")
public class SaleController {
    
    @Autowired
    SaleService saleService;

    @Autowired
    SaleReportService saleReportService;
    
    List<SaleReport> saleReports = new ArrayList<>();

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;
    

    @GetMapping("/")
    public String findAllSales(Model model){
        List<Sale> sales = saleService.findAll();
        model.addAttribute("sales", sales);
        return "/views/sale/list";
    }

    @GetMapping("/new")
    public String newSale(Model model){

        Map<String, Object> data = new HashMap<>();
        
        data.put("sale", new Sale());
        data.put("clients", clientService.findAll());
        data.put("users", userService.findAll());
        data.put("products", productService.findAll());
        data.put("saleReport", new SaleReport());
        data.put("saleReports", saleReports);



        model.addAllAttributes(data);

        return "/views/sale/create";
    }

    @GetMapping("/list/{id}")
    public String findSaleById(Model model, @PathVariable int id){
        Map<String, Object> data = new HashMap<>();

        data.put("sale", saleService.findSaleById(id));
        data.put("clients", clientService.findAll());
        data.put("users", userService.findAll());

        model.addAllAttributes(data);
        return "/views/sale/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteSale(@PathVariable int id){
        saleService.deleteSaleById(id);
        return "redirect:/sales/";
    }


    // POST Endpoint

    @PostMapping("/save")
    public String saveSale(Sale sale){

        double valorVenta = 0;
        double ivaVenta = 0;
        double totalVenta = 0;

        for (SaleReport saleReport : saleReports) {
            valorVenta = saleReport.getValorVenta() * saleReport.getCantidadProducto();
            ivaVenta = Math.round(valorVenta * (saleReport.getProducto().getIva()/100));
            totalVenta = valorVenta + ivaVenta;

            saleReport.setValorVenta(valorVenta);
            saleReport.setValorIva(ivaVenta);
            saleReport.setValorTotal(totalVenta);

            valorVenta += saleReport.getValorVenta();
            ivaVenta += saleReport.getValorIva();
            totalVenta += saleReport.getValorTotal();
        }

        sale.setValorVenta(valorVenta);
        sale.setIvaVenta(ivaVenta);
        sale.setTotalVenta(totalVenta);

        Sale saleSaved = saleService.createSale(sale);

        for (SaleReport saleReport : saleReports) {
            saleReport.setVenta(saleSaved);
            System.out.println(saleReport.toString());
        }

        saleReportService.createManySaleReports(saleReports);
        saleReports.clear();

        return "redirect:/sales/";
    }

    @PostMapping("/saveTempSaleReport")
    public String saveTempSaleReport(SaleReport saleReport){
        try {

            double productPrice = saleReport.getProducto().getPrecioVenta();
            double productIva = saleReport.getProducto().getIva()/100;
            double productTotal = productPrice * saleReport.getCantidadProducto();
            double productIvaTotal = Math.round(productTotal * productIva);
            double productValue = productTotal + productIvaTotal;

            saleReport.setValorVenta(productTotal);
            saleReport.setValorIva(productIvaTotal);
            saleReport.setValorTotal(productValue);

            saleReports.add(saleReport);

            return "redirect:/sales/new";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/sales/new";
        }
    }

}
