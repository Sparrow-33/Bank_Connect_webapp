package com.simplon.bank_connect.transactions;

import com.simplon.bank_connect.card.Card;
import com.simplon.bank_connect.client.Client;
import com.simplon.bank_connect.compte.Compte;
import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_seq", allocationSize = 1)
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "transaction_seq")
    private Long id;

    private String dateTransaction = java.time.LocalDate.now().toString();

    private String typeTransaction;

    private double montantTransaction;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "destinataire_id" , nullable = false)
    private Compte destinataire;

    public Transaction() {
    }

    public Transaction(String dateTransaction, String typeTransaction, double montantTransaction, TransactionType type, Compte emetteur, Compte destinataire) {
        this.dateTransaction = dateTransaction;
        this.typeTransaction = typeTransaction;
        this.montantTransaction = montantTransaction;
        this.type = type;
        this.destinataire = destinataire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(String dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public double getMontantTransaction() {
        return montantTransaction;
    }

    public void setMontantTransaction(double montantTransaction) {
        this.montantTransaction = montantTransaction;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }


    public Compte getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(Compte destinataire) {
        this.destinataire = destinataire;
    }
}
