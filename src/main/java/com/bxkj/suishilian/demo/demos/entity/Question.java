package com.bxkj.suishilian.demo.demos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Map;


@Entity
//@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;
    private String stem;
    private String answer;
    // 用 @OneToMany 注解来映射集合字段
    @JsonIgnore
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Option> options;
    private int questionTypeId;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", stem='" + stem + '\'' +
                ", answer='" + answer + '\'' +
                ", options=" + options +
                ", questionTypeId=" + questionTypeId +
                '}';
    }

    public Question() {
    }

    public Question(String number, String stem, String answer, List<Option> options, int questionTypeId) {
        this.number = number;
        this.stem = stem;
        this.answer = answer;
        this.options = options;
        this.questionTypeId = questionTypeId;
    }

    // Getter和Setter方法


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
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

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public int getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(int questionTypeId) {
        this.questionTypeId = questionTypeId;
    }
}