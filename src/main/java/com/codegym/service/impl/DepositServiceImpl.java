package com.codegym.service.impl;

import com.codegym.DTO.DepositDTO;
import com.codegym.model.Deposit;
import com.codegym.repository.IDepositRepository;
import com.codegym.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class DepositServiceImpl implements IDepositService {
    @Autowired
    private IDepositRepository depositRepository;

    @Autowired
    private IUserRepository userRepository;


    @Override
    public Iterable<Deposit> findAll() {
        return null;
    }

    @Override
    public Optional<Deposit> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Deposit save(Deposit deposit) {
        return depositRepository.save(deposit);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Optional<DepositDTO> findByDepositDTO(Long id) {
        return depositRepository.findByDepositDTO(id);
    }
}
