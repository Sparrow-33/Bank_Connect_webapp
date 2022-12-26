package com.simplon.bank_connect.transactions;


import com.simplon.bank_connect.compte.Compte;
import com.simplon.bank_connect.compte.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {


    private final TransactionRepository transactionRepository;
    private final CompteService compteService;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }


    public Transaction deposit(Long id, Transaction transaction) {
        assert  transaction.getType().equals(TransactionType.DEPOT);
        Compte compte = compteService.getCompteStandardById(id);
        if (compte != null) {
            if (compteService.checkStatus(compte)) {
                compte.setSolde(compte.getSolde() + transaction.getMontantTransaction());
//                transaction.
                return saveTransaction(transaction);
            }
        }
        return null;
    }


}

