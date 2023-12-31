package com.example.homeworkspring.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByIsDeletedIsFalse();
    Optional<User> findByUuid(String uuid);
}
