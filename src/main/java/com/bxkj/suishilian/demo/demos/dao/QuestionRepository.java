package com.bxkj.suishilian.demo.demos.dao;

import com.bxkj.suishilian.demo.demos.entity.Question;
import com.bxkj.suishilian.demo.demos.entity.QuestionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository  extends JpaRepository<Question, Integer> {

}
