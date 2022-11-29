package com.example.quartz.controller;

import com.example.quartz.config.TimerInfo;
import com.example.quartz.service.PlaygroundService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timer")

public class PlaygroundController {

    private PlaygroundService service;

    public PlaygroundController(PlaygroundService service) {
        this.service = service;
    }

    public PlaygroundController() {
    }

    @PostMapping("/runhelloworld")
    public void runHelloWorldJob() {
        service.runHelloWorldJob();
    }

    @GetMapping
    public List<TimerInfo> getAllRunningTimers() {
        return service.getAllRunningTimers();
    }

    @GetMapping("/{timerId}")
    public TimerInfo getRunningTimer(@PathVariable String timerId) {
        return service.getRunningTimer(timerId);
    }

    @DeleteMapping("/{timerId}")
    public Boolean deleteTimer(@PathVariable String timerId) {
        return service.deleteTimer(timerId);
    }


}
