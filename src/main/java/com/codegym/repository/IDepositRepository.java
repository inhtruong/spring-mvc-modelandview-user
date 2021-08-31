package com.codegym.repository;

import com.codegym.DTO.DepositDTO;
import com.codegym.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDepositRepository extends JpaRepository<Deposit, Long> {

    @Query (value = "SELECT NEW com.codegym.DTO.DepositDTO (u.id, u.name, u.balance) FROM User u WHERE u.id = ?1")
    Optional<DepositDTO> findByDepositDTO(Long id);


}
