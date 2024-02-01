package com.bxkj.suishilian.demo.demos.utils;

import com.bxkj.suishilian.demo.demos.entity.Option;
import com.bxkj.suishilian.demo.demos.entity.Question;

import java.util.List;

public class QuestionWithOptions {
    private Question question;
    private List<Option> options;

    // Constructors, getters, and setters

    public QuestionWithOptions(Question question, List<Option> options) {
        this.question = question;
        this.options = options;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
