package com.example.homeworkspring.api.RoleAuthority;

import com.example.homeworkspring.api.auth.Authority;
import com.example.homeworkspring.api.role.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "role_authorities")
public class RoleAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;


}