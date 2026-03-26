package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.SecondYellowCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecondYellowCardsRepository extends JpaRepository<SecondYellowCards, Integer> {
 
}
