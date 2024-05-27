package com.example.activities.service;

import com.example.activities.models.Activity;
import com.example.activities.models.Participant;
import com.example.activities.repository.ActivityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    private final ParticipantService participantService;

    @Autowired
    public ActivityService (ActivityRepository activityRepository, ParticipantService participantService) {
        this.activityRepository = activityRepository;
        this.participantService = participantService;
    }

    public List<Activity> getActivities() {
        return activityRepository.findAll();
    }

    public Activity getActivity(Long id){
        return activityRepository.findById(id).orElseThrow();
    }

    public Optional<Activity> findById(Long id) {
        return activityRepository.findById(id);
    }

    public List<Activity> getActivityByName(String name){
        return activityRepository.getByName(name);
    }

    public Activity saveAct(Activity a){
        return this.activityRepository.save(a);
    }



    @Transactional
    public void restDelete(Long id){
        activityRepository.deleteById(id);
    }

}
