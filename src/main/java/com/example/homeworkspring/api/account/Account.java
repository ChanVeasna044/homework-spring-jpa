package com.example.homeworkspring.api.account;

import com.example.homeworkspring.api.accounttype.AccountType;
import com.example.homeworkspring.api.useraccount.UserAccount;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String uuid;


    private String accountNo;
    private String accountName;
    private String profile;
    private Integer pin;
    private String phoneNumber;
    private Integer transferLimit;
    @OneToMany(mappedBy="account")
    private List<UserAccount> userAccounts;

    @ManyToOne
    @JoinColumn(name = "account_type")
    private AccountType accountType;
}

