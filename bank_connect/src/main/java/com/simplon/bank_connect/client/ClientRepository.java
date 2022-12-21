package com.simplon.bank_connect.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository
        extends JpaRepository<Client, Long> {

    public Client findClientByEmail(String email);
}

