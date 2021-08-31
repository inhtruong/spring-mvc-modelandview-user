package com.codegym.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name_user")
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String country;

    private BigDecimal balance;

    public User(Long id,@NotEmpty String name,@NotEmpty BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

}
