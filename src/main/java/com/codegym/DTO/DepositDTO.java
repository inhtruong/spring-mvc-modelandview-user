package com.codegym.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositDTO {
    private Long userId;
    private String name;
    private BigDecimal balance;
    private BigDecimal depositAmount;

    public DepositDTO(Long userId, String name, BigDecimal balance) {
        this.userId = userId;
        this.name = name;
        this.balance = balance;
    }
}
