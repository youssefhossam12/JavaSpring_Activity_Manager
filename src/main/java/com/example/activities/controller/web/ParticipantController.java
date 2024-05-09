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

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            this.participantService.delete(id);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return "delete_success";
    }

    @GetMapping("/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Participant participant = participantService.getParticipantById(id);
        model.addAttribute("participant", participant);
        model.addAttribute("activities", activityService.getActivities());
        return "edit_participant";
    }

/*    @PostMapping("/update/{id}")
    public String updateParticipant(@PathVariable Long id, @Valid @ModelAttribute Participant participant, BindingResult result
    , Model model){
        if (result.hasErrors())
            return "edit_participant";
        Participant participant1 = participantService.getParticipantById(id);
        participant1.setName(participant1.getName());
        participant1.setEmail(participant1.getEmail());
        participant1.setPhoneNumber(participant1.getPhoneNumber());

        participantService.save(participant1);
        model.addAttribute("participant", participantService.getParticipants());
        return "success";
    }*/
    @PostMapping("/{id}")
    public String updateParticipant(@PathVariable Long id,String name, String email, String phone,  @ModelAttribute Participant participant) {
        participant.setName(name);
        participant.setEmail(email);
        participant.setPhoneNumber(phone);
        participantService.save(participant);
        return "success";
    }
}
