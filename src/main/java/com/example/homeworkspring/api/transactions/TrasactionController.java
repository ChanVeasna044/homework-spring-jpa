package com.example.homeworkspring.api.transactions;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@RequestMapping
@RequiredArgsConstructor
public class TrasactionController {
    private final TransactioService transactionService;

    @Transactional
    @PostMapping
    public ResponseEntity<String> transferFunds(
            @RequestParam Long fromAccountId,
            @RequestParam Long toAccountId,
            @RequestParam BigDecimal amount) {
        transactionService.performTransaction(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok("*Sender from account id:"+fromAccountId
                +" *Receiver from account id:"+toAccountId+" *amount is:"+amount);
    }
}
