package com.simplon.bank_connect.compte;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface CompteRepository
        extends org.springframework.data.jpa.repository.JpaRepository<Compte, Long> {

    Compte findByNumeroCompte(String numeroCompte);
}
