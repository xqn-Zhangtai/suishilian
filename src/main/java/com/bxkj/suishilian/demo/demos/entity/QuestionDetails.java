package com.bxkj.suishilian.demo.demos.entity;

public class QuestionDetails {
    private String number;
    private String stem;
    private String answer;
    private String optionKey;
    private String optionValue;

    // 构造函数
    public QuestionDetails(String number, String stem, String answer, String optionKey, String optionValue) {
        this.number = number;
        this.stem = stem;
        this.answer = answer;
        this.optionKey = optionKey;
        this.optionValue = optionValue;
    }

    // 空构造函数
    public QuestionDetails() {
    }

    // getter和setter
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(String optionKey) {
        this.optionKey = optionKey;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
