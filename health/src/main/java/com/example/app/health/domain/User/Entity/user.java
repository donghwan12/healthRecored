package com.example.app.health.domain.User.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class user {
    @Id
    private String id;

    private String name;
    private String email;
    private String nickname;
    private String password;
    private String phone;
}
