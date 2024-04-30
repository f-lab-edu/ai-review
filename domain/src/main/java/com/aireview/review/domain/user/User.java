package com.aireview.review.domain.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private String password;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status {
        ENABLED, DISABLED;
    }

    public User(String name, String nickname, String email, String password) {
        this(null, name, nickname, password, email, Status.ENABLED);
    }

    public User(Long id, String name, String nickname, String password, String email, Status status) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.status = status;
    }
}
