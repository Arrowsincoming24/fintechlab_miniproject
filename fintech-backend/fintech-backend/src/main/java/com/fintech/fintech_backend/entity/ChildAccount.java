package com.fintech.fintech_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "child_accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChildAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "parent_id", nullable = false)
    private ParentAccount parentAccount;
}
