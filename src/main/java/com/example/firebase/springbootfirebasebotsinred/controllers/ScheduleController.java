package com.example.firebase.springbootfirebasebotsinred.controllers;

import com.example.firebase.springbootfirebasebotsinred.entities.Schedule;
import com.example.firebase.springbootfirebasebotsinred.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/deviceID")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/schedules/{userID}")
    public List<Schedule> getSchedule(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        return scheduleService.getSchedules(userID);
    }

    @GetMapping("/schedules")
    public List<Schedule> getSchedules() throws ExecutionException, InterruptedException {
        return scheduleService.getAllSchedules();
    }
}
