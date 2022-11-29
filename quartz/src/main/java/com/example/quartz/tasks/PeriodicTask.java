package com.example.quartz.tasks;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Date;

@Component
public class PeriodicTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void everyFiveSeconds() {
        System.out.println(MessageFormat.format("Periodic task: {0}; Thread: {1}",
                new Date().toString(), Thread.currentThread().getName()));
    }
}
