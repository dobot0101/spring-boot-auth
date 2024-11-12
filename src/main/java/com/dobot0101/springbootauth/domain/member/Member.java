package com.dobot0101.springbootauth.domain.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "members")
public class Member {
    @Id
    private UUID id;
    private String email;
    private String name;
    private String password;

    protected Member() {
    }

    public Member(UUID id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
