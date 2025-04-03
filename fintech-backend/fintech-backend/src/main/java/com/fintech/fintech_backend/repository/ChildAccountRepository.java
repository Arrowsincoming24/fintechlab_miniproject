package com.fintech.fintech_backend.repository;

import com.fintech.fintech_backend.entity.ChildAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChildAccountRepository extends JpaRepository<ChildAccount, Long> {
    List<ChildAccount> findByParentAccountId(Long parentId); // Find children of a parent
}
