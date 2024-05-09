package com.example.activities.controller.web;

import com.example.activities.models.Participant;
import com.example.activities.service.ActivityService;
import com.example.activities.service.ParticipantService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/participant")
@Log4j2
public class ParticipantController {

    private ParticipantService participantService;
    private ActivityService activityService;

    public ParticipantController(ParticipantService participantService, ActivityService activityService) {
        this.participantService = participantService;
        this.activityService = activityService;
    }



    @GetMapping("/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Participant participant = participantService.getParticipantById(id);
        model.addAttribute("participant", participant);
        model.addAttribute("activities", activityService.getActivities());
        return "edit_participant";
    }

    @PostMapping("/{id}")
    public String updateParticipant(@PathVariable Long id,  @ModelAttribute Participant participant, Model model) {
        Participant participant1= participantService.getParticipantById(id);
        participant1.setName(participant.getName());
        participant1.setEmail(participant.getEmail());
        participant1.setPhoneNumber(participant.getPhoneNumber());
        model.addAttribute("participant", participantService.getParticipants());
        participantService.save(participant1);
        return "success";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            this.participantService.delete(id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "delete_success";
    }
}
