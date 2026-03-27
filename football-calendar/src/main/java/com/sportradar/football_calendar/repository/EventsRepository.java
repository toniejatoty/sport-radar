package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.Events;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {

    @Query("SELECT e FROM Events e "
            + "LEFT JOIN FETCH e._homeTeam "
            + "LEFT JOIN FETCH e._awayTeam "
            + "LEFT JOIN FETCH e._stage "
            + "LEFT JOIN FETCH e._result "
            + "LEFT JOIN FETCH e._group "
            + "LEFT JOIN FETCH e._event_metadate")
    List<Events> findAllEfficiently();

    @Query("SELECT e FROM Events e "
            + "left JOIN FETCH e._homeTeam "
            + "left JOIN FETCH e._awayTeam "
            + "left JOIN FETCH e._stage "
            + "LEFT JOIN FETCH e._result "
            + "LEFT JOIN FETCH e._event_metadate "
            + "WHERE e.id = :id")
    Events findByIdEfficiently(@Param("id") Integer id);

}
