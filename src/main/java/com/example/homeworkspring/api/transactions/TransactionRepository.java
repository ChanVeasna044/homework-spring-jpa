package com.example.homeworkspring.api.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions,Integer> {
    @Modifying
    @Query(value = "CALL transfer_funds(:fromAccountId, :toAccountId, :amount)", nativeQuery = true)
    void transferFunds(
            @Param("fromAccountId") Long fromAccountId,
            @Param("toAccountId") Long toAccountId,
            @Param("amount") BigDecimal amount

    );
}
