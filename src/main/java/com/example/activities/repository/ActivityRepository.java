package com.example.activities.repository;

import com.example.activities.models.Activity;
import com.example.activities.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(nativeQuery = true, value = "select a.* from activity a" +
            " join part_act pa on a.id = pa.act_id" +
            " join participant p on p.id = pa.part_id" +
            " where p.name like :name")
    List<Activity> getByName(@Param("name") String name);
}
