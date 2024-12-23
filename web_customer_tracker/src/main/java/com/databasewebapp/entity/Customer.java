package com.databasewebapp.entity;

import jakarta.persistence.*;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull(message = "First name cannot be null")
    @Size(min = 3, max = 20, message = "First name must be between 3 and 20 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotNull(message = "Last name cannot be null")
    @Size(min = 3, max = 20, message = "Last name must be between 3 and 20 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Must be a well-formed email address")
    @Column(name = "email")
    private String email;
}
