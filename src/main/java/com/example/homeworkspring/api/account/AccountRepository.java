package com.example.homeworkspring.api.account;

import com.example.homeworkspring.api.user.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    Optional<Account> findAccountByUuid(String uuid);
}
