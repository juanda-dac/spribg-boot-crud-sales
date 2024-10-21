package ute.edu.java.corte2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ute.edu.java.corte2.model.Sale;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import ute.edu.java.corte2.service.ClientService;
import ute.edu.java.corte2.service.SaleService;
import ute.edu.java.corte2.service.UserService;

@Controller
@RequestMapping("/sales")
public class SaleController {
    
    @Autowired
    SaleService saleService;

    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

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
        sale.setTotalVenta(sale.getValorVenta() + sale.getIvaVenta());
        saleService.createSale(sale);
        return "redirect:/sales/";
    }

}
