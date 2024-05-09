package com.example.activities.service;

import com.example.activities.models.Activity;
import com.example.activities.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;

    @Autowired
    public ActivityService (ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
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







}
