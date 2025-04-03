package com.fintech.fintech_backend.controller;

import com.fintech.fintech_backend.entity.ChildAccount;
import com.fintech.fintech_backend.service.ChildAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/children")
public class ChildAccountController {

    private final ChildAccountService childAccountService;

    public ChildAccountController(ChildAccountService childAccountService) {
        this.childAccountService = childAccountService;
    }

    // Create a child account linked to a parent
    @PostMapping("/{parentId}")
    public ResponseEntity<ChildAccount> createChild(@PathVariable Long parentId, @RequestBody ChildAccount child) {
        ChildAccount savedChild = childAccountService.createChild(parentId, child);
        return ResponseEntity.ok(savedChild);
    }

    // Get child by ID
    @GetMapping("/{id}")
    public ResponseEntity<ChildAccount> getChildById(@PathVariable Long id) {
        Optional<ChildAccount> child = childAccountService.getChildById(id);
        return child.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
