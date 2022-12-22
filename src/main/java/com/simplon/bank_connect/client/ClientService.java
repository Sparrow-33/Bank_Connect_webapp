package com.simplon.bank_connect.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {



     Client saveClient(Client client) ;


     Client getClientById(Long id) ;

     Client getClientByCin(String cin);


     List<Client> getAllClients() ;

    Client getClientByEmail(String email);

    String generateCode();
}
