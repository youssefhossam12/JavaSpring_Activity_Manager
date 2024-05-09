package com.example.activities.controller.rest;

import com.example.activities.Const;
import com.example.activities.models.Activity;
import com.example.activities.service.ActivityService;
import com.example.activities.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(Const.REST_API_URL+"/activity")
public class ActivityRestController {

    private final ActivityService activityService;
    private final ParticipantService participantService;

    @Autowired
    public ActivityRestController(ActivityService activityService, ParticipantService participantService){
        this.activityService = activityService;
        this.participantService = participantService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getById(@PathVariable("id") Long id){
        Optional<Activity> a= activityService.findById(id);
        return ResponseEntity.of(a);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Activity>> getAll(){
        List<Activity> result = this.activityService.getActivities();
        return ResponseEntity.ok(result);
    }


}
