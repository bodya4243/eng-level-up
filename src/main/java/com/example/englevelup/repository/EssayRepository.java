package com.example.englevelup.repository;

import com.example.englevelup.model.EnglishLevel;
import com.example.englevelup.model.writing.Essay;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EssayRepository extends JpaRepository<Essay, Long> {
    List<Essay> findAllByLevel(@Param("level") EnglishLevel level);
}
