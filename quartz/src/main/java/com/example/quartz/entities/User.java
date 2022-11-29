package com.example.quartz.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="user_seq", sequenceName = "USER_seq", allocationSize=50)
    private Long id;

    @NotNull
    @NotEmpty
    @Column(name = "name",length = 60)
    private String name;
    @Email
    @NotEmpty
    @Column(name = "mail",length = 255 , unique = true)
    private String mail;

    @NotNull
    @Column(name = "hello_send")
    private Boolean helloSend;


}
