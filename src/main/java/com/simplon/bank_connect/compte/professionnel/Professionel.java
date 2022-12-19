package com.simplon.bank_connect.compte.professionnel;

import com.simplon.bank_connect.compte.CompteType;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Professionel
            extends com.simplon.bank_connect.compte.Compte {

    private Double maxPerDay;

    private Double maxPerYear;


    private LocalDate updated_at;

    public Professionel() {
    }

    public Professionel(Double maxPerDay, Double maxPerYear, LocalDate dateCreation, LocalDate dateExpiration, LocalDate updated_at) {
        this.maxPerDay = maxPerDay;
        this.maxPerYear = maxPerYear;
        this.updated_at = updated_at;
    }

    public Professionel(String numeroCompte, double solde, CompteType type, Double maxPerDay, Double maxPerYear, LocalDate dateCreation, LocalDate dateExpiration, LocalDate updated_at) {
        super(numeroCompte, solde, password, type);
        this.maxPerDay = maxPerDay;
        this.maxPerYear = maxPerYear;
        this.updated_at = updated_at;
    }
}
