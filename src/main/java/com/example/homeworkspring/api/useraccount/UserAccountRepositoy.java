package com.example.homeworkspring.api.useraccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepositoy extends JpaRepository<UserAccount,Integer> {
    List<UserAccount> findByUserUuid(String uuid);
    Optional<UserAccount> findByUser_UuidAndAccount_Uuid(String userUuid, String accountUuid);
}
