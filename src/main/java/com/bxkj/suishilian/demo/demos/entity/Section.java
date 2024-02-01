package com.bxkj.suishilian.demo.demos.entity;

import java.util.List;

public class Section {
    private String sectionNumber;
    private String sectionTitle;
    private List<Question> questions;

    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionNumber='" + sectionNumber + '\'' +
                ", sectionTitle='" + sectionTitle + '\'' +
                ", questions=" + questions +
                '}';
    }

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getSectionTitle() {
        return sectionTitle;
    }

    public void setSectionTitle(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
