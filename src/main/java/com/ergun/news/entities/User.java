package com.ergun.news.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "Username can't be empty!")
    @NotBlank(message = "Username can't be empty!")
    @Size(max = 16, message = "Username must be less than 16 characters!")
    @Column(name = "username")
    private String username;

    @NotNull(message = "Password can't be empty!")
    @NotBlank(message = "Password can't be empty!")
    @Size(min = 8, max = 16, message = "Password must be greater than 8 and less than 16 characters!")
    @Column(name = "password")
    private String password;
}