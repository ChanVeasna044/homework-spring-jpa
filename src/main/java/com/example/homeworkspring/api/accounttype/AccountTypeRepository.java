package com.example.homeworkspring.api.accounttype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType,Integer> {
}
