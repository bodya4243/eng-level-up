package com.example.englevelup.repository;

import com.example.englevelup.model.quiz.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Query("SELECT q FROM Quiz q JOIN FETCH q.questions WHERE q.focus = :focus")
    Quiz findByFocus(@Param("focus") String focus);
}
