package com.example.quartz.dto;
import com.example.quartz.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String mail;

    private Boolean helloSend;

}
