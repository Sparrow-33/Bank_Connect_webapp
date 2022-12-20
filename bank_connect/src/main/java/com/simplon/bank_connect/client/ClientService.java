package com.simplon.bank_connect.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public Client saveClient(Client client) {
        System.out.println(client);
        return clientRepository.save(client);
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id).get();
    }

    public Client getClientByCin(String cin) {
        return clientRepository.findByCin(cin);
    }




}
