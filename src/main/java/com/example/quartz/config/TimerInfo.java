package com.example.quartz.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor

public class TimerInfo implements Serializable {
    private int totalFireCount;
    private int remainingFireCount;
    private boolean runForever;
    private long repeatIntervalMs;
    private long initialOffsetMs;
    private String callbackData;

    public TimerInfo() {
    }
}
