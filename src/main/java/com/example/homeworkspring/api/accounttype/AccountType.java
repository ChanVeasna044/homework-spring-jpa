package com.example.homeworkspring.api.accounttype;

import jakarta.persistence.*;
import lombok.*;

@Entity@Table(name = "accounts_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class AccountType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
