package com.bxkj.suishilian.demo.demos.service;
import com.bxkj.suishilian.demo.demos.dao.OptionRepository;
import com.bxkj.suishilian.demo.demos.dao.QuestionRepository;
import com.bxkj.suishilian.demo.demos.dto.OptionDTO;
import com.bxkj.suishilian.demo.demos.dto.QuestionDTO;
import com.bxkj.suishilian.demo.demos.entity.Option;
import com.bxkj.suishilian.demo.demos.entity.Question;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private OptionRepository optionRepository;

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Question getQuestionById(Integer id) {
        Question question = questionRepository.findById(id).orElse(null);

//        if (question != null) {
//            Hibernate.initialize(question.getOptions());  // 强制加载选项
//        }
        return question;
    }
    public List<Option> getOptionsByQuestionId(Integer questionId) {
        return optionRepository.findByQuestionId(questionId);
    }

}
