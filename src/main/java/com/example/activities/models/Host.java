package com.example.activities.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

@Entity
@NoArgsConstructor
@Data
@SuperBuilder
@Table(name = "host")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Host extends AbstractEntity{

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "enter a valid email")
    @NotEmpty(message = "must enter an email")
    private String email;

    /*@OneToOne(mappedBy = "host")*/
   /* @JsonIgnore
    @OneToOne
    @JoinColumn(name = "participant_id", nullable = true)
    private Participant participant;*/



}
