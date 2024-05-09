package com.example.activities.controller.web;

import com.example.activities.models.Activity;
import com.example.activities.models.Participant;
import com.example.activities.repository.ParticipantRepository;
import com.example.activities.service.ActivityService;
import com.example.activities.service.HostService;
import com.example.activities.service.ParticipantService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
/*@RequestMapping("/register")*/
public class RegistrationController {
    private ActivityService activityService;
    private ParticipantService participantService;

    public  RegistrationController(ActivityService activityService, ParticipantService participantService){
        this.activityService = activityService;
        this.participantService = participantService;
    }

    /*@GetMapping("/activity/{id}")
    public String registerParticipant( @PathVariable Long id) {
        Participant participant = participantService.getParticipantById(id);
        //participantService.registerParticipant(participant);
        return "redirect:/activity/list";
    }*/

    @GetMapping("/register")
    public String getReg(Model model){
        Participant participant = new Participant();
        model.addAttribute("activities", activityService.getActivities());
        model.addAttribute("participant", participant);
        return "regis_part";
    }


    @PostMapping("/register")
    public String regPart(Participant participant){
        participantService.save(participant);
        return "/success";
    }

/*    @PostMapping("/register")
    public String registerParticipant(@ModelAttribute Participant participant, @RequestParam("id") Long[] id){
        Set<Activity> selectedActivity = new HashSet<>();
        for (Long id : id ){
            Activity activity = activityService.getActivity(id);
        }
        participant.setActivities(selectedActivity);
        participantService.save(participant);
        return "/success";
    }*/




}
