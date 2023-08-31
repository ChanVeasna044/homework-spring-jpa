package com.example.homeworkspring.api.transactions;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactioService {
    private final TransactionRepository transactionRepository;
    @Override
    public void performTransaction(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        transactionRepository.transferFunds(fromAccountId, toAccountId, amount);
    }
}
