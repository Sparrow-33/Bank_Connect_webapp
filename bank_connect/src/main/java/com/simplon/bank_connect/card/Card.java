package com.simplon.bank_connect.card;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import java.time.LocalDate;

@Entity
public class Card {

    @Id
    @SequenceGenerator(name = "card_seq", sequenceName = "card_seq", allocationSize = 1)
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "card_seq")
    private Long id;

    private String numeroCarte;

    private LocalDate dateCreation = java.time.LocalDate.now();

    private LocalDate dateExpiration = java.time.LocalDate.now().plusYears(10);

    private int cvv = (int)(Math.random()*500)+100;





    public Card() {
    }

    public Card(String numeroCarte, LocalDate dateCreation, LocalDate dateExpiration, int cvv) {
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

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public int getCvc() {
        return cvv;
    }

    public void setCvc(int cvv) {
        this.cvv = cvv;
    }



}
