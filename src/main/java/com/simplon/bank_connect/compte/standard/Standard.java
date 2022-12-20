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

    @Override
    public String toString() {
        return "\nStandard{" +
                "maxPerDay=" + maxPerDay +
                ", maxPerYear=" + maxPerYear +
                ", updated_at=" + updated_at +
                ", numeroCompte='" + super.getNumeroCompte() + '\'' +
                ", solde=" + super.getSolde() +
                ", password='" + super.getPassword() + '\'' +
                ", type=" + super.getType() +
                '}';
    }

}
