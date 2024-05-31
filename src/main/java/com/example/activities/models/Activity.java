package com.example.activities.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "date", nullable = false)
    @NotNull(message = "Please enter a date for the activity")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;


    @Column(name = "location", unique = false, nullable = false)
    @NotEmpty(message ="please enter a location for the activity" )
    private String location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "host_id")
    private Host host;

    @ManyToMany(mappedBy = "activities", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    private List<Participant> participantSet;


}
