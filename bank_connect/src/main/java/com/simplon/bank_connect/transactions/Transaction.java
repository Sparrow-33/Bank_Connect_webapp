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

    private Long idCompteDestinataire;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "compte_id" , nullable = false)
    private Compte compte;


}
