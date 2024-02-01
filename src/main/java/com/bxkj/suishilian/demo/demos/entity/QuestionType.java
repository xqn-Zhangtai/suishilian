package com.bxkj.suishilian.demo.demos.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
//@Entity
public class QuestionType {
    private String type;
    private int score;
    private int totalQuestions;
    private List<Question> questions;

    public QuestionType(String type, int score, int totalQuestions) {
        this.type = type;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.questions = new ArrayList<>();
    }

    // Getter和Setter方法
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

}
