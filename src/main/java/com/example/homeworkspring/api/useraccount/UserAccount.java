package com.example.homeworkspring.api.useraccount;

import com.example.homeworkspring.api.account.Account;
import com.example.homeworkspring.api.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users_accounts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private LocalDateTime createdAt;

  private LocalDateTime updateAt;
    private Boolean isDisabled;
}
