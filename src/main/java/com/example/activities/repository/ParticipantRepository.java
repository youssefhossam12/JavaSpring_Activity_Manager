package com.example.activities.repository;


import com.example.activities.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {


/*    @Query(nativeQuery = true, value = "select p.* from participant p" +
            " join part_act pa on p.id = pa.part_id" +
            " join activity a on a.id = pa.act_id" +
            " where a.name like :name")
    List<Participant> getByName(@Param("name") String name);*/

/*    @Query(nativeQuery = true, value = "select pa.part_name from part_act pa" +
            " join activity a on a.id = pa.act_id" +
            " where a.name like :name")
    List<Participant> getByName(@Param("name") String name);*/

    /*@Query(nativeQuery = true, value = "select id from participant where email = :email")
    Long isRegistered(@Param("email") String email);*/

/*    @Modifying
    @Query(nativeQuery = true, value = "insert into part_act (part_id,act_id) "+
            "select p.id, a.id " +
            "from participant p " +
            "cross join activity a " +
            "where p.id = :id ")
    List<Participant> partActUpdate(@Param("id") Long id);*/


}
