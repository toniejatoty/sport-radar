package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.YellowCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YellowCardsRepository extends JpaRepository<YellowCards, Integer> {
 
}
