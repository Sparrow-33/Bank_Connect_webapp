package com.simplon.bank_connect.card;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Card {

    @Id
    @SequenceGenerator(name = "card_seq", sequenceName = "card_seq", allocationSize = 1)
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "card_seq")
    private Long id;

    private String numeroCarte;

    private String dateCreation;

    private String dateExpiration;

    private int cvv;


    public Card() {
    }

    public Card(String numeroCarte, String dateCreation, String dateExpiration, int cvv) {
        this.numeroCarte = numeroCarte;
        this.dateCreation = dateCreation;
        this.dateExpiration = dateExpiration;
        this.cvv = cvv;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCarte() {
        return numeroCarte;
    }

    public void setNumeroCarte(String numeroCarte) {
        this.numeroCarte = numeroCarte;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(String dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public int getCvc() {
        return cvv;
    }

    public void setCvc(int cvv) {
        this.cvv = cvv;
    }



}
