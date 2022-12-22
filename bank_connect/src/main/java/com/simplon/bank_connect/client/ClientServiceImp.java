package com.simplon.bank_connect.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id){
        return clientRepository.findById(id).get();
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }
}
