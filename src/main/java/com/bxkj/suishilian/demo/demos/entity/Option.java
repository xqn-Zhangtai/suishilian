package com.bxkj.suishilian.demo.demos.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
@Entity

public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "label", nullable = false)
    private String label;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "id")  // 这里假设question表的主键字段名为question_id
    private Question question;  // 关联的问题

    @Override
    public String toString() {
        return "Option{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", content='" + content + '\'' +
                ", question=" + question +
                '}';
    }

    public Option() {
        // JPA要求的无参构造函数
    }

    // 有参构造函数（可根据需要添加）

    public Option(String label, String content) {
        this.label = label;
        this.content = content;
    }

    // Getter 和 Setter 方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
