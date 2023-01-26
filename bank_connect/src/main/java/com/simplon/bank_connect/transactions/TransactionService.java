package com.simplon.bank_connect.transactions;


import com.simplon.bank_connect.compte.Compte;
import com.simplon.bank_connect.compte.CompteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
        Compte compte = compteService.getCompteStandardById(id);
        if (compte != null) {
            if (compteService.checkStatus(compte)) {
                compteService.updateCompteSolde(compte, transaction.getMontantTransaction());
                transaction.setSender(compte);
                transaction.setRecipient(compte);
                return saveTransaction(transaction);
            }
        }else {
            Compte comptePro = compteService.getCompteProById(id);
            if (comptePro != null) {
                if (compteService.checkStatus(comptePro)) {
                    compteService.updateCompteSolde(comptePro, comptePro.getSolde());
                    transaction.setSender(comptePro);
                    transaction.setRecipient(comptePro);
                    return saveTransaction(transaction);
                }
            }
        }
        return null;
    }

    public Transaction withdraw(Long id, Transaction transaction) {
        Compte compte = compteService.getCompteStandardById(id);
        if (compte != null) {
            if (compteService.checkStatus(compte)) {
                compteService.updateCompteSolde(compte, -transaction.getMontantTransaction());
                transaction.setSender(compte);
                transaction.setRecipient(compte);
                return saveTransaction(transaction);
            }
        }else {
            Compte comptePro = compteService.getCompteProById(id);
            if (comptePro != null) {
                if (compteService.checkStatus(comptePro)) {
                    compteService.updateCompteSolde(comptePro, -comptePro.getSolde());
                    transaction.setSender(comptePro);
                    transaction.setRecipient(comptePro);
                    return saveTransaction(transaction);
                }
            }
        }
        return null;
    }


}

