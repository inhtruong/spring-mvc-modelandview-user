package com.codegym.controller;

import com.codegym.model.User;
import com.codegym.service.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView("user/list", "userList", userService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreateUser() {
        ModelAndView modelAndView = new ModelAndView("user/create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/save-insert")
    public ModelAndView createUser(@Validated User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("user/create", "error", "Error");
        }
        ModelAndView modelAndView = new ModelAndView("user/create");
        userService.save(user);
        modelAndView.addObject("success", "Successfully added new");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView formDeleteUser(@PathVariable Long id) {
        return new ModelAndView("user/delete", "user", userService.findById(id));
    }

    @PostMapping("/save-delete")
    public ModelAndView deleteUser(User user) {
        ModelAndView modelAndView = new ModelAndView("user/delete");;
        userService.remove(user.getId());
        modelAndView.addObject("success", "Delete successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView formEditUser(@PathVariable Long id) {
        return new ModelAndView("user/edit", "user", userService.findById(id));
    }

    @PostMapping("/save-edit")
    public ModelAndView editUser(User user) {
        ModelAndView modelAndView = new ModelAndView("user/edit");;
        userService.save(user);
        modelAndView.addObject("success", "Edit successfully");
        return modelAndView;
    }
}
