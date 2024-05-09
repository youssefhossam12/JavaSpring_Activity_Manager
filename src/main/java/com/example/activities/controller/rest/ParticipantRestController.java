package com.example.activities.controller.rest;

import com.example.activities.Const;
import com.example.activities.models.Activity;
import com.example.activities.models.Participant;
import com.example.activities.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Const.REST_API_URL+"/participant")
public class ParticipantRestController {
    private final ParticipantService participantService;

    @Autowired
    public ParticipantRestController(ParticipantService participantService){
        this.participantService = participantService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Participant>> getAllParticipants(){
        List<Participant> p= this.participantService.getParticipants();
        return ResponseEntity.ok(p);
    }
}
