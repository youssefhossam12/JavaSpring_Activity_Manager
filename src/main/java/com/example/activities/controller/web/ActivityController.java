package com.example.activities.controller.web;

import com.example.activities.models.Activity;
import com.example.activities.repository.ParticipantRepository;
import com.example.activities.service.ActivityService;
import com.example.activities.service.HostService;
import com.example.activities.service.ParticipantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/activity")
@Log4j2
public class ActivityController {
    private ActivityService activityService;
    private ParticipantService participantService;
    private HostService hostService;
    private ParticipantRepository participantRepository;

    public ActivityController(ActivityService activityService, ParticipantService participantService, HostService hostService
        , ParticipantRepository participantRepository){
        this.activityService = activityService;
        this.participantService = participantService;
        this.hostService = hostService;
        this.participantRepository = participantRepository;
    }

    @GetMapping("/list")
    public String getData (Model model){
        model.addAttribute("activities", activityService.getActivities());
        return "activities_list";

    }

    @GetMapping("/list/host")
    public String getHosts (Model model){
        model.addAttribute("hosts", hostService.GetHosts());
        return "hosts_list";

    }


    @GetMapping("/participants")
    public String getPart(Model model){
        model.addAttribute("participants",participantService.getParticipants());
        return "participant_list";
    }


    @GetMapping("/{name}")
    public String showHosts(@PathVariable("name") String name, Model model){
        model.addAttribute("hosts", hostService.GetHostByAct(name));
        return "hosts_list";
    }


    /*    @GetMapping("/list/{name}")
    public String showActivity(@PathVariable("name") String name, Model model){
        model.addAttribute("participants",participantService.getParticipantsByAct(name));
        return "participant_list";
    }*/



}
