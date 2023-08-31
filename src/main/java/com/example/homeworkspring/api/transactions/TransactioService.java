package com.example.homeworkspring.api.transactions;

import java.math.BigDecimal;

public interface TransactioService {
    void performTransaction(Long fromAccountId, Long toAccountId, BigDecimal amount);
}
