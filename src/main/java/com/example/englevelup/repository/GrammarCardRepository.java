package com.example.englevelup.repository;

import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.grammarcard.GrammarCard;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarCardRepository extends JpaRepository<GrammarCard, Long> {
    @Query("SELECT gc FROM GrammarCard gc JOIN FETCH gc.content WHERE gc.level = :englishLevel")
    List<GrammarCard> findAllByLevelWithContent(EnglishLevel englishLevel);
}
