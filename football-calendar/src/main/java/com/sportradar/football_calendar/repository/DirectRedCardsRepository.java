package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.DirectRedCards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectRedCardsRepository extends JpaRepository<DirectRedCards, Integer> {
 
}
