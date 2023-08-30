package com.example.homeworkspring.api.userRole;

import com.example.homeworkspring.api.role.Role;
import com.example.homeworkspring.api.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users_roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}
