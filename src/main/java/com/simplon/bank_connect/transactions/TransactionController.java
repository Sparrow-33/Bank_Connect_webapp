package com.simplon.bank_connect.transactions;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {


    private final TransactionService transactionService;



    @PostMapping("/deposit/{id}")
    public Transaction deposit(@PathVariable("id") Long id, @RequestBody Transaction transaction) {
        return transactionService.deposit(id, transaction);
    }

}
