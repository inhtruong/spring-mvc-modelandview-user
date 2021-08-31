package com.codegym.service.impl;

import com.codegym.DTO.DepositDTO;
import com.codegym.model.Deposit;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface IDepositService extends IGeneralService<Deposit> {

    Optional<DepositDTO> findByDepositDTO(Long id);
}
