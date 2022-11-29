package com.example.quartz.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class EmailConfig {
  //  @Value("spring.mail.host")
    private String host = "smtp.mailtrap.io";
  //  @Value("spring.mail.port")
    private int port= 2525;
 //   @Value("spring.mail.username")
    private String username= "4920cae6aae156";
  //  @Value("${spring.mail.password}")
    private String password= "fc1f6e4c287641";


}
