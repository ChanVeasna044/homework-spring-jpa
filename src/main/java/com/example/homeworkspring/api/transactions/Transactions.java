package com.example.homeworkspring.api.transactions;

import com.example.homeworkspring.api.account.Account;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private Account receiverAccount;

    private BigDecimal amount;
    private String remark;
    private Boolean isPayment;
    private Integer paymentId;
    private Integer phoneNumber;
    private LocalDateTime transferedAt;

}