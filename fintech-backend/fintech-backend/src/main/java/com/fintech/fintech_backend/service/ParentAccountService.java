package com.fintech.fintech_backend.service;

import com.fintech.fintech_backend.entity.ParentAccount;
import com.fintech.fintech_backend.entity.ChildAccount;
import com.fintech.fintech_backend.repository.ParentAccountRepository;
import com.fintech.fintech_backend.repository.ChildAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentAccountService {

    private final ParentAccountRepository parentAccountRepository;
    private final ChildAccountRepository childAccountRepository;

    public ParentAccountService(ParentAccountRepository parentAccountRepository, ChildAccountRepository childAccountRepository) {
        this.parentAccountRepository = parentAccountRepository;
        this.childAccountRepository = childAccountRepository;
    }

    // Create a new parent account
    public ParentAccount createParent(ParentAccount parent) {
        return parentAccountRepository.save(parent);
    }

    // Get parent account by ID
    public Optional<ParentAccount> getParentById(Long id) {
        return parentAccountRepository.findById(id);
    }

    // Get parent account by email
    public Optional<ParentAccount> getParentByEmail(String email) {
        return parentAccountRepository.findByEmail(email);
    }

    // Get all children linked to a parent
    public List<ChildAccount> getChildrenOfParent(Long parentId) {
        return childAccountRepository.findByParentAccountId(parentId);
    }
}
