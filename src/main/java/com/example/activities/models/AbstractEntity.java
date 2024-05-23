package com.example.activities.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;


@NoArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
abstract public class AbstractEntity{

    @Id
    @Column(name = "id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY  )
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    @Length(min = 2, max = 50)
    @NotEmpty(message = " name required")
    private String name;


    @CreationTimestamp
    private Date created;
}
