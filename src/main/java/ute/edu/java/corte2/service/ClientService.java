package ute.edu.java.corte2.service;

import java.util.List;

import ute.edu.java.corte2.model.Client;;

public interface ClientService {
    List<Client> findAll();

    Client createClient(Client client);

    Client searchClientById(Integer cedula);

    void deleteClient(Integer cedula);
}
