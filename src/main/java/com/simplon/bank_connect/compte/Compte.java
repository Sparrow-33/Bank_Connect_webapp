package com.simplon.bank_connect.compte;

import com.simplon.bank_connect.card.Card;
import com.simplon.bank_connect.client.Client;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "compte_seq")
    @SequenceGenerator(name = "compte_seq", sequenceName = "compte_seq", allocationSize = 1)
    private Long id;

    private String numeroCompte;

    private Double solde;

    private String password;

    @Enumerated(EnumType.STRING)
    private CompteType type;


    public Compte() {
    }

    public Compte(String numeroCompte, Double solde, String password, CompteType type) {
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

    public Double getSolde() {
        return solde;
    }

    public CompteType getType() {
        return type;
    }

    public void setType(CompteType type) {
        this.type = type;
    }



    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    private Card card;


    @Override
    public String toString() {
        return "\nCompte{" +
                "id=" + id +
                ", numeroCompte='" + numeroCompte + '\'' +
                ", solde=" + solde +
                ", type=" + type +
                ", client=" + client +
                ", card=" + card +
                '}';
    }

}
