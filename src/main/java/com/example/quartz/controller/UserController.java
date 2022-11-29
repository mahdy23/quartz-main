package com.example.quartz.controller;


import com.example.quartz.dto.UserCreateDto;
import com.example.quartz.entities.User;
import com.example.quartz.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")

@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("")
    public User save (@Valid @RequestBody UserCreateDto userCreateDto){
        return userService.save(userCreateDto);
    }

    @GetMapping("")
    public List<User> getUsers() {

        return userService.getAll();
    }

    @GetMapping("/tosend")
    public List<User> findUserByHelloSend() {
        return userService.findUserByHelloSend();
    }

}
