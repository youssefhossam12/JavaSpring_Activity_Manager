package com.example.activities.service;

import com.example.activities.models.Activity;
import com.example.activities.models.Participant;
import com.example.activities.repository.ActivityRepository;
import com.example.activities.repository.ParticipantRepository;
import jakarta.servlet.http.Part;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final ActivityRepository activityRepository;


    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, ActivityRepository activityRepository){
        this.participantRepository = participantRepository;
        this.activityRepository = activityRepository;
    }

    public List<Participant> getParticipants(){
        return this.participantRepository.findAll();
    }

    public Participant getParticipantById(Long id){
        return participantRepository.findById(id).orElseThrow(()->
                new IllegalStateException(String.format("no participant found with id: %s", id)));
    }

    public Optional<Participant> restGetById(Long id){return this.participantRepository.findById(id);}



    public void save(Participant participant) {

            participantRepository.save(participant);

    }

    public Participant savePart(Participant p){
        return this.participantRepository.save(p);
    }


    public void updateParticipant(Long id, String name, String email, String phone){
        Participant participant= participantRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("participant with the id " + id + " does not exist"));
        if (!name.isEmpty()){
            participant.setName(name);
        }
        if (!email.isEmpty()){
            participant.setEmail(email);
        }
        if (!phone.isEmpty()){
            participant.setPhoneNumber(phone);
        }
         participantRepository.save(participant);
    }
    @Transactional
    public void update( String name, String email, String phone, Participant participant){


        participantRepository.save(participant);
    }



    @Transactional
    public void delete(Long id){
        if (!participantRepository.existsById(id)){
            throw new IllegalStateException("no participant with this id: "+ id);
        }

        participantRepository.deleteById(id);
    }






    /*    public List<Participant> getParticipantsByAct(String name){
        return participantRepository.getByName(name);
    }
    public List<Participant> getNewParticipant(Long id){
        return participantRepository.partActUpdate(id);
    }*/

   /* public void registerParticipant(Activity activity, Participant participant) {
        activity.getParticipants().add(participant);
        activityRepository.save(activity);
    }*/
}
