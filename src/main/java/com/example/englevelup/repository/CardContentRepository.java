package com.example.englevelup.repository;

import com.example.englevelup.model.grammarcard.GrammarCardContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardContentRepository extends JpaRepository<GrammarCardContent, Long> {
}
