package com.simplon.bank_connect.compte;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "compte_seq")
    @SequenceGenerator(name = "compte_seq" , sequenceName = "compte_seq" , allocationSize = 1)
    private Long id;

    private String numeroCompte;

    private double solde;

    private CompteType type;


    public Compte() {
    }

    public Compte(String numeroCompte, double solde, CompteType type) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCompte() {
        return numeroCompte;
    }

    public void setNumeroCompte(String numeroCompte) {
        this.numeroCompte = numeroCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public CompteType getType() {
        return type;
    }

    public void setType(CompteType type) {
        this.type = type;
    }
}
