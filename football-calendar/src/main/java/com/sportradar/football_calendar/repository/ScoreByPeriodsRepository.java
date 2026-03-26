package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.ScoreByPeriods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreByPeriodsRepository extends JpaRepository<ScoreByPeriods, Integer> {
 
}
