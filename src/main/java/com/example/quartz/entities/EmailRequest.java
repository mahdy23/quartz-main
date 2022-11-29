package com.example.quartz.entities;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
@Data
public class EmailRequest {
    @NotEmpty
    private String mail;


    private String feedback;

    @Email
    @NotEmpty
    private String name;
}
