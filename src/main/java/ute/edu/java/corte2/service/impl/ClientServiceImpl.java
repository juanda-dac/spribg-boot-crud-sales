package ute.edu.java.corte2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import ute.edu.java.corte2.model.Client;
import ute.edu.java.corte2.repository.ClientRepository;
import ute.edu.java.corte2.service.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client searchClientById(Integer cedula) {
        return clientRepository.findById(cedula).orElse(null);
    }

    @Override
    public void deleteClient(Integer cedula) {
        clientRepository.deleteById(cedula);
    }


}
