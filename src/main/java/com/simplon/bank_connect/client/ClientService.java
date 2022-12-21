package com.simplon.bank_connect.client;

public interface ClientService {
     Client saveClient(Client client);
     Client getClientById(Long id);
     Client getClientByEmail(String email);
}
