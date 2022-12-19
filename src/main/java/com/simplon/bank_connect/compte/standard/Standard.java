package com.simplon.bank_connect.compte.standard;

import com.simplon.bank_connect.compte.Compte;
import com.simplon.bank_connect.compte.CompteType;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Standard extends Compte {

    private Double maxPerDay;

    private Double maxPerYear;

    private LocalDate updated_at;

    public Standard() {
    }

    public Standard(Double maxPerDay, Double maxPerYear, LocalDate updated_at) {
        this.maxPerDay = maxPerDay;
        this.maxPerYear = maxPerYear;
        this.updated_at = updated_at;
    }

    public Standard(String numeroCompte, Double solde, String password, CompteType type, Double maxPerDay, Double maxPerYear, LocalDate dateCreation, LocalDate dateExpiration, LocalDate updated_at) {
        super(numeroCompte, solde, password, type);
        this.maxPerDay = maxPerDay;
        this.maxPerYear = maxPerYear;
        this.updated_at = updated_at;
    }



}
