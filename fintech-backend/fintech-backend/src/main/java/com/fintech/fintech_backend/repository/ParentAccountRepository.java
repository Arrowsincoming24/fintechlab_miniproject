package com.fintech.fintech_backend.repository;

import com.fintech.fintech_backend.entity.ParentAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ParentAccountRepository extends JpaRepository<ParentAccount, Long> {
    Optional<ParentAccount> findByEmail(String email); // Find parent by email
}
