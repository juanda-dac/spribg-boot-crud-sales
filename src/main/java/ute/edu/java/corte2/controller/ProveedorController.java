package ute.edu.java.corte2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ute.edu.java.corte2.model.Proveedor;
import ute.edu.java.corte2.service.ProveedorService;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    ProveedorService proveedorService;

    @RequestMapping("/")
    public String getProveedores(Model model) {
        List<Proveedor> proveedores = proveedorService.findAll();
        model.addAttribute("proveedores", proveedores);
        return "/views/proveedor/list";
    }

    @RequestMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "/views/proveedor/create";
    }

    @RequestMapping("/list/{nit}")
    public String listById(@PathVariable int nit, Model model) {
        Proveedor proveedor = proveedorService.searchProveedorById(nit);
        model.addAttribute("proveedor", proveedor);
        return "/views/proveedor/edit";
    }

    @PostMapping("/save")
    public String saveProduct(Proveedor proveedor, Model model){
        proveedorService.createProveedor(proveedor);
        return "redirect:/proveedor/";
    }

    @RequestMapping("/delete/{nit}")
    public String deleteProduct(@PathVariable int nit, Model model){
        proveedorService.deleteProveedor(nit);
        return "redirect:/proveedor/";
    }
}
