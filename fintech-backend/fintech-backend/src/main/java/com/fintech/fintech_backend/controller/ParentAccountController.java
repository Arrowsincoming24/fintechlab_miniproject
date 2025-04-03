package com.fintech.fintech_backend.controller;

import com.fintech.fintech_backend.entity.ParentAccount;
import com.fintech.fintech_backend.entity.ChildAccount;
import com.fintech.fintech_backend.service.ParentAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parents")
public class ParentAccountController {

    private final ParentAccountService parentAccountService;

    public ParentAccountController(ParentAccountService parentAccountService) {
        this.parentAccountService = parentAccountService;
    }

    // Create a new parent account
    @PostMapping
    public ResponseEntity<ParentAccount> createParent(@RequestBody ParentAccount parent) {
        ParentAccount savedParent = parentAccountService.createParent(parent);
        return ResponseEntity.ok(savedParent);
    }

    // Get parent by ID
    @GetMapping("/{id}")
    public ResponseEntity<ParentAccount> getParentById(@PathVariable Long id) {
        Optional<ParentAccount> parent = parentAccountService.getParentById(id);
        return parent.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
    // Get all
