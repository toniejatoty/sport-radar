package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

}
