package com.example.englevelup.repository;

import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.Reading;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Long> {
    List<Reading> findAllByLevel(@Param("level") EnglishLevel level);
}
