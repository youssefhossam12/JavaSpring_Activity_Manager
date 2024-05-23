package com.example.activities.controller.rest;

import com.example.activities.Const;
import com.example.activities.models.Activity;
import com.example.activities.models.Participant;
import com.example.activities.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Participant> getById(@PathVariable("id") Long id){
        Optional<Participant> p = participantService.restGetById(id);
        return ResponseEntity.of(p);
    }

    @PostMapping(value = "/add",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Participant> add(@RequestBody Participant p, @PathVariable(required = false) Long id){
        if (p.getId() != null){
            throw new ResourceAlreadyExistsException("cannot add new participant");
        }
        if (p.getName() == null && p.getEmail() == null && p.getPhoneNumber() == null){
            p.setName(p.getName());
            p.setEmail(p.getEmail());
            p.setPhoneNumber(p.getPhoneNumber());
        }
        return ResponseEntity.ok(this.participantService.savePart(p));
    }

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Participant> update(@RequestBody Participant p){
        Participant part = this.participantService.getParticipantById(p.getId());
        p.setName(p.getName());
        p.setEmail(p.getEmail());
        p.setPhoneNumber(p.getPhoneNumber());

        return ResponseEntity.ok(this.participantService.savePart(p));

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){
        Participant p =this.participantService.getParticipantById(id);
        this.participantService.delete(id);
        return ResponseEntity.ok().build();
    }

}
