package com.codegym.controller;

import com.codegym.DTO.DepositDTO;
import com.codegym.service.impl.IDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users/service")
public class DWTController {
    @Autowired
    private IDepositService depositService;

    @GetMapping("/deposit/{id}")
    public ModelAndView formDeposit(@PathVariable Long id) {
        return new ModelAndView("service/deposit", "deposit", depositService.findByDepositDTO(id));
    }
}
