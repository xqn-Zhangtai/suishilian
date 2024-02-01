package com.bxkj.suishilian.demo.demos.dao;

import com.bxkj.suishilian.demo.demos.entity.Option;
import com.bxkj.suishilian.demo.demos.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, Integer> {
    @Query(value = "SELECT o.* FROM question q LEFT JOIN `option` o ON q.id = o.question_id WHERE o.question_id IS NOT NULL AND q.id = :questionId", nativeQuery = true)
    List<Option> findByQuestionId(@Param("questionId")Integer questionId);
}
