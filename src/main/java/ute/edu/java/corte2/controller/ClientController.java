package ute.edu.java.corte2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import ute.edu.java.corte2.model.Client;
import ute.edu.java.corte2.service.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {
    
    @Autowired
    ClientService clientService;

    @RequestMapping("/")
    public String getClients(Model model) {
        List<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "/views/client/list";
    }

    @RequestMapping("/new")
    public String newClient(Model model) {
        model.addAttribute("client", new Client());
        return "/views/client/create";
    }

    @RequestMapping("/list/{cedula}")
    public String listById(@PathVariable int cedula, Model model) {
        Client client = clientService.searchClientById(cedula);
        model.addAttribute("client", client);
        return "/views/client/edit";
    }


    @RequestMapping("/delete/{cedula}")
    public String deleteClient(@PathVariable int cedula, Model model) {
        clientService.deleteClient(cedula);
        return "redirect:/client/";
    }

    @PostMapping("/save")
    public String saveClient(Client client, Model model) {
        clientService.createClient(client);
        return "redirect:/client/";
    }

}
