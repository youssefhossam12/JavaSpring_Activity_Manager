package com.example.activities.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@SuperBuilder
@Table(name = "participant")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Participant extends AbstractEntity{


    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "enter a valid email")
    @NotEmpty(message = "must enter an email")
    private String email;

    @Column(name = "phone", nullable = false)
    @NotEmpty(message = "Please enter the phone number!")
    private String phoneNumber;

    @ManyToMany
    @JoinTable(name="part_act",
            joinColumns = {@JoinColumn(name = "part_id")},
            inverseJoinColumns = {@JoinColumn(name = "act_id")}
    )
    private Set<Activity> activities;
/*    @JsonIgnore
    @OneToOne(mappedBy = "participant")
    private Host host ;*/

}
