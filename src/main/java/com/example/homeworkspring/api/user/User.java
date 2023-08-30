package com.example.homeworkspring.api.user;

import com.example.homeworkspring.api.userRole.UserRole;
import com.example.homeworkspring.api.useraccount.UserAccount;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(unique = true,nullable = false)

    private String uuid;
    private String name;
    private String gender;
    @Column(name = "phone_number")
    private String phoneNumber;
//    @Column(name = "one_signal_id",unique = true,nullable = false)
    private String oneSignalId;
//    @Column(name = "is_deleted",unique = true,nullable = false)
    @Column(nullable = false)
   private Boolean isDeleted;
//    @Column(name = "is_student",unique = true,nullable = false)
    private Boolean isStudent;
//    @Column(name = "student_card_no",unique = true,nullable = false)
    private String studentCardNo;
    private String password;
    private String email;
//    @Column(name = "is_verified",unique = true,nullable = false)
    private Boolean isVerified;
//    @Column(name = "verified_code",unique = true,nullable = false)
    private String verifiedCode;

    @OneToMany(mappedBy = "user")
    List<UserAccount> userAccounts;
    @OneToMany(mappedBy ="user")
    List<UserRole>userRoles;


}

