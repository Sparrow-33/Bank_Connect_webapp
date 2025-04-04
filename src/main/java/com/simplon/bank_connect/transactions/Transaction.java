package com.simplon.bank_connect.transactions;

import com.simplon.bank_connect.card.Card;
import com.simplon.bank_connect.client.Client;
import com.simplon.bank_connect.compte.Compte;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    @SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_seq", allocationSize = 1)
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.SEQUENCE, generator = "transaction_seq")
    private Long id;

    private LocalDate dateTransaction = java.time.LocalDate.now();


    private double montantTransaction;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private Compte sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id")
    private Compte recipient;

    public Compte getRecipient() {
        return recipient;
    }

    public void setRecipient(Compte recipient) {
        this.recipient = recipient;
    }


    public Transaction() {
    }

    public Transaction(LocalDate dateTransaction,  double montantTransaction, TransactionType type,Compte sender, Compte recipient) {
        this.dateTransaction = dateTransaction;
        this.montantTransaction = montantTransaction;
        this.sender = sender;
        this.type = type;
        this.recipient = recipient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compte getSender() {
        return sender;
    }

    public void setSender(Compte sender) {
        this.sender = sender;
    }

    public LocalDate getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDate dateTransaction) {
        this.dateTransaction = dateTransaction;
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
        return recipient;
    }

    public void setDestinataire(Compte recipient) {
        this.recipient = recipient;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", dateTransaction=" + dateTransaction +
                ", montantTransaction=" + montantTransaction +
                ", type=" + type +
                ", sender=" + sender +
                ", recipient=" + recipient +
                '}';
    }
}
