package com.example.firebase.springbootfirebasebotsinred.controllers;

import com.example.firebase.springbootfirebasebotsinred.entities.Schedule;
import com.example.firebase.springbootfirebasebotsinred.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/")
public class ScheduleController {
    List<Schedule> schedules;
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/fetchnwdata/{userID}")
    public <T> T getSchedule(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        schedules = scheduleService.getSchedules(userID);
        if( schedules.isEmpty() ){
            return (T) new String("false");
        }
        return (T) new ArrayList<Schedule>(schedules);
    }

    @GetMapping("/isnwdata/{userID}")
    public String hasDataUpdated(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        return Boolean.toString(scheduleService.hasDataUpdated(userID));
    }

    @GetMapping("/schedules")
    public <T> T getSchedules() throws ExecutionException, InterruptedException {
        schedules = scheduleService.getAllSchedules();
        if( schedules.isEmpty() ){
            return (T) new String("false");
        }
        return (T) new ArrayList<Schedule>(schedules);
    }

    @GetMapping("/fetchdata/{userID}")
    public <T> T getAllSchedule(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        schedules = scheduleService.getAllSchedule(userID);
        if( schedules.isEmpty() ){
            return (T) new String("false");
        }
        return (T) new ArrayList<Schedule>(schedules);
    }
}
