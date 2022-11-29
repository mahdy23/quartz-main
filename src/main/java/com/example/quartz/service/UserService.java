package com.example.quartz.service;

import com.example.quartz.dto.UserCreateDto;
import com.example.quartz.entities.User;
import com.example.quartz.repository.UserRepository;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;


import java.util.List;

@AllArgsConstructor
@JsonSerialize
@Service
public class UserService {
    private final UserRepository userRepository;


    public User save(UserCreateDto userCreateDto){
        User user= new User(null,userCreateDto.getName(),userCreateDto.getMail(),userCreateDto.getHelloSend());
        return userRepository.save(user);

    }
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public List<User>findUserByHelloSend(){
        return userRepository.findUserByHelloSend(false);



    }



}
