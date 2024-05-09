package com.example.activities.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name= "activity")
@NoArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Activity extends AbstractEntity {


    @Column(name = "description",nullable = false, length = 300)
    @NotEmpty(message ="please enter a description for the activity" )
    private String description;

    @Column(name = "date", unique = false, nullable = false)
    @NotEmpty(message ="please enter a date for the activity" )
    private Date date;


    @Column(name = "location", unique = false, nullable = false)
    @NotEmpty(message ="please enter a location for the activity" )
    private String location;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "host_id")
    private Host host;

    @ManyToMany(mappedBy = "activities", fetch = FetchType.LAZY)
    private Set<Participant> participantSet;


}
