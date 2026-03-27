package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalsRepository extends JpaRepository<Goals, Integer> {

}
