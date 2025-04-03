package com.fintech.fintech_backend.service;

import com.fintech.fintech_backend.entity.ChildAccount;
import com.fintech.fintech_backend.entity.ParentAccount;
import com.fintech.fintech_backend.repository.ChildAccountRepository;
import com.fintech.fintech_backend.repository.ParentAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChildAccountService {

    private final ChildAccountRepository childAccountRepository;
    private final ParentAccountRepository parentAccountRepository;

    public ChildAccountService(ChildAccountRepository childAccountRepository, ParentAccountRepository parentAccountRepository) {
        this.childAccountRepository = childAccountRepository;
        this.parentAccountRepository = parentAccountRepository;
    }

    // Create a new child account linked to a parent
    public ChildAccount createChild(Long parentId, ChildAccount child) {
        ParentAccount parent = parentAccountRepository.findById(parentId)
                .orElseThrow(() -> new IllegalArgumentException("Parent not found"));
        child.setParentAccount(parent);
        return childAccountRepository.save(child);
    }

    // Get child account by ID
    public Optional<ChildAccount> getChildById(Long id) {
        return childAccountRepository.findById(id);
    }
}
