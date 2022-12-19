package com.simplon.bank_connect.compte.professionnel;

import com.simplon.bank_connect.compte.CompteType;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Professionel
            extends com.simplon.bank_connect.compte.Compte {

    private Double maxPerDay = 10000.0;

    private Double maxPerYear = 200000.0;


    private LocalDate updated_at;

    public Professionel() {
    }

    public Professionel(Double maxPerDay, Double maxPerYear, LocalDate dateCreation, LocalDate dateExpiration, LocalDate updated_at) {
        this.maxPerDay = maxPerDay;
        this.maxPerYear = maxPerYear;
        this.updated_at = updated_at;
    }

    public Professionel(String numeroCompte, Double solde, String password, CompteType type, Double maxPerDay, Double maxPerYear, LocalDate dateCreation, LocalDate dateExpiration, LocalDate updated_at) {
        super(numeroCompte, solde, password, type);
        this.maxPerDay = maxPerDay;
        this.maxPerYear = maxPerYear;
        this.updated_at = updated_at;
    }

    public Double getMaxPerDay() {
        return maxPerDay;
    }

    public void setMaxPerDay(Double maxPerDay) {
        this.maxPerDay = maxPerDay;
    }

    public Double getMaxPerYear() {
        return maxPerYear;
    }

    public void setMaxPerYear(Double maxPerYear) {
        this.maxPerYear = maxPerYear;
    }

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }
}
