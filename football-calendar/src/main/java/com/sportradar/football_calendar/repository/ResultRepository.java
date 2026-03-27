package com.sportradar.football_calendar.repository;

import com.sportradar.football_calendar.model.Result;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {

    @Query(
            "Select r from Result r"
            + " left join fetch r.winner"
    )
    List<Result> findAllResults();

}
