package ute.edu.java.corte2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ute.edu.java.corte2.model.Product;
import ute.edu.java.corte2.service.ProductService;
import ute.edu.java.corte2.service.ProveedorService;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ProveedorService proveedorService;

    @GetMapping("/new")
    public String newProduct(Model model) {
        Map<String, Object> mapData = new HashMap<String, Object>();
        mapData.put("product", new Product());
        mapData.put("proveedores", proveedorService.findAll());

        model.addAllAttributes(mapData);
        
        return "/views/product/create";
    }

    @GetMapping("/list/{codigo}")
    public String listProduct(Model model, @PathVariable Integer codigo) {
        Product product = productService.searchProductById(codigo);
        Map<String, Object> mapData = new HashMap<String, Object>();
        
        mapData.put("product", product);
        mapData.put("proveedores", proveedorService.findAll());

        model.addAllAttributes(mapData);
        return "/views/product/edit";
    }

    @GetMapping("/delete/{codigo}")
    public String deleteProduct(Model model, @PathVariable Integer codigo) {
        productService.deleteProduct(codigo);
        return "redirect:/products/";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/views/product/list";
    }


    @PostMapping("/save")
    public String save(Product product, Model model) {
        productService.createProduct(product);
        return "redirect:/products/";
    }
}
