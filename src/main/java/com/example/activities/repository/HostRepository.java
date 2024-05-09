package com.example.activities.repository;


import com.example.activities.models.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
    @Query(nativeQuery = true, value = "select h.* from host h" +
            " join activity a on h.id = a.host_id " +
            " where a.name like :name")
    List<Host> getByHostName(@Param("name") String name);
}
