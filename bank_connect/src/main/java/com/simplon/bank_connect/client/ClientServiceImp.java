package com.simplon.bank_connect.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ClientServiceImp(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Client saveClient(Client client){
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id){
        return clientRepository.findById(id).get();
    }

    @Override
    public Client getClientByCin(String cin) {
        return null;
    }

    @Override
    public List<Client> getAllClients() {
        return null;
    }

    @Override
    public Client getClientByEmail(String email) {
        return clientRepository.findClientByEmail(email);
    }

    @Override
    public String generateCode() {
        int code = (int) (Math.random() * 90000) + 10000;
        return String.valueOf(code);
    }
}
