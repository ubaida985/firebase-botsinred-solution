package com.example.firebase.springbootfirebasebotsinred.controllers;

import com.example.firebase.springbootfirebasebotsinred.entities.Schedule;
import com.example.firebase.springbootfirebasebotsinred.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/fetchnwdata/{userID}")
    public List<Schedule> getSchedule(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        List<Schedule> schedules = scheduleService.getSchedules(userID);
        if( schedules.isEmpty() ){
            hasDataUpdated(userID);
        }
        return schedules;
    }

    @GetMapping("/isnwdata/{userID}")
    public String hasDataUpdated(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        return Boolean.toString(scheduleService.hasDataUpdated(userID));
    }

    @GetMapping("/schedules")
    public List<Schedule> getSchedules() throws ExecutionException, InterruptedException {
        return scheduleService.getAllSchedules();
    }

    @GetMapping("/fetchdata/{userID}")
    public List<Schedule> getAllSchedule(@PathVariable String userID ) throws ExecutionException, InterruptedException {
        return scheduleService.getAllSchedule(userID);
    }
}
