package com.example.englevelup.repository;

import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.grammarcard.GrammarCard;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GrammarCardRepository extends JpaRepository<GrammarCard, Long> {
    @Query("SELECT gc FROM GrammarCard gc JOIN FETCH gc.content WHERE gc.level = :englishLevel")
    List<GrammarCard> findAllByLevelWithContent(EnglishLevel englishLevel);

    @Query("SELECT gc FROM GrammarCard gc JOIN FETCH gc.content")
    List<GrammarCard> findAllWithContent();

    @EntityGraph(attributePaths = "content")
    Page<GrammarCard> findAll(Pageable pageable);

    @Query("SELECT g FROM GrammarCard g LEFT JOIN FETCH g.content WHERE g.id = :id")
    Optional<GrammarCard> findByIdWithContent(Long id);
}
